import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {MembersService} from "../../../services/members.service";
import {Course} from "../../../interfaces/Course";
import {CoursesService} from "../../../services/courses.service";
import {Homework} from "../../../interfaces/Homework";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HomeworksService} from "../../../services/homeworks.service";
import { Location } from '@angular/common';
import {UploadService} from "../../../services/UploadService";
import {Router} from "@angular/router";

@Component({
  selector: 'ip-newhomework',
  templateUrl: './newhomework.component.html',
  styleUrls: ['./newhomework.component.css']
})
export class NewhomeworkComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalAddMember: ModalComponent;
  @Output() pageChanged = new EventEmitter();
  // students: any;
  courses: any;
  homework: Homework = new Homework();
  homeworkForm: FormGroup;
  submitted = false;
  private filesUploaded: Array<File> = [];
  private files: Array<any> = [];
  loaded = false;
  fileSrc: any;
  private uploadStarted:boolean = false;
  private uploadFinished:boolean = false;
  @ViewChild('progressStatus') private progressStatus:any;
  @ViewChild('progressText') private progressText:any;
  id = sessionStorage.getItem("userId");

  constructor(
    private memberService: MembersService,
    private coursesService: CoursesService,
    private homeworksService: HomeworksService,
    private uploadService: UploadService,
    private fb: FormBuilder,
    private location: Location,
    public router: Router
  ) {
    this.router = router;
  }

  ngOnInit() {

    this.getCourses();
    this.homework.id_student = this.id;
    this.buildForm();
  }

  // getStudents() {
  //   this.memberService.getList().subscribe((response) => {
  //     this.students = response.content;
  //   });
  // }

  getCourses() {
    this.coursesService.getList().subscribe((response) => {
      this.courses = response.content;
    });
  }

  chooseCourse(id) {
    this.homework.id_curs = id;
  }

  open() {
    // this.err = false;
    // this.studentid = id;
    this.modalAddMember.open();
  }

  close() {
    this.modalAddMember.close();
  }

  onSubmit(isvalid) {
    this.submitted = true;
    this.onValueChanged();
    if (isvalid) {
      this.homeworksService.addHomework(this.homework).subscribe(
        (response) => {
          if (this.filesUploaded.length > 0)
            this.startUpload(this.id, this.filesUploaded);
          else this.location.back();
        }
      );
    }

  }

  buildForm(): void {
    this.homeworkForm = this.fb.group({
      'type': [this.homework.tip_tema, [
        Validators.required
      ]],
      'date': [this.homework.data_predare, [
        Validators.required
      ]]
    });

    this.homeworkForm.valueChanges.debounceTime(1000).subscribe(data => {
      this.onValueChanged(data)
    });
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.homeworkForm) {
      return;
    }
    const form = this.homeworkForm;

    for (const field in this.formErrors) {
      this.formErrors[field] = '';
      const control = form.get(field);
      if (control && this.submitted && !control.valid) {
        const messages = this.validationMessages[field];
        for (const key in control.errors) {
          if (this.formErrors[field].length > 0) break;
          this.formErrors[field] += messages[key] + ' ';
        }
      }
    }
  }

  formErrors = {
    'type': '',
    'date': ''
  };

  validationMessages = {
    'type': {
      'required': 'Alegeti tipul temei'
    },
    'date': {
      'required': 'Introduceti data'
    }
  };

  handleInputChange(e) {
    this.filesUploaded = e.target.files;
    let reader;
    for (let file of this.filesUploaded) {
      reader = new FileReader();
      reader.onload = this._handleReaderLoaded.bind(this);
      reader.readAsDataURL(file);
    }
  }

  _handleReaderLoaded(e) {
    var reader = e.target;
    this.fileSrc = reader.result;
    this.files.push(reader.result);
    this.loaded = true;
  }

  startUpload(id, fileList) {
    this.uploadService.uploadProductsImages(id, fileList).subscribe(
      data => {
        this.uploadStarted = false;
        this.uploadFinished = true;
        this.modalAddMember.close();
        this.pageChanged.emit(true);
      },
      error => console.log(error)
    );
    this.uploadStarted = true;
    this.uploadService.progress.subscribe((res) => {
      this.progressStatus.nativeElement.style.width = res + "%";
      this.progressText.nativeElement.innerHTML = res + "%";
    });
  }

}
