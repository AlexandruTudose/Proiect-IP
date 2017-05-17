import {Component, OnInit, ViewChild, EventEmitter, Output} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Course} from "../../../interfaces/Course";
import {CoursesService} from "../../../services/courses.service";

@Component({
  selector: 'ip-editcourse',
  templateUrl: './editcourse.component.html',
  styleUrls: ['./editcourse.component.css']
})
export class EditcourseComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalEdit: ModalComponent;
  errorlength = false;
  private coruseUrl: string = "/api/courses/";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  course: Course = new Course();
  courseid: any;

  constructor(private coursesService: CoursesService) {
  }

  ngOnInit() {
  }

  getCourse(url,id) {
    this.coursesService.getMember(url,id).subscribe((response) => {
      this.course = response;
    });
  }

  open(id) {
    this.err = false;
    this.courseid = id;
    this.getCourse(this.coruseUrl, this.courseid);
    this.modalEdit.open();
  }

  close() {
    this.modalEdit.close();
  }

  addObject() {
    this.addMember();
  }

  addMember() {
    this.coursesService.updateMember(this.coruseUrl,this.course.id, this.course).subscribe(
      (succes) => {
        this.modalEdit.close();
        this.pageChanged.emit(true);
      },
      (error) => {
        this.err = true;
      },
      () => {
      }
    );
  }
}
