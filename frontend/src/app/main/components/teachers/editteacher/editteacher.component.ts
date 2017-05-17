import {Component, OnInit, ViewChild, EventEmitter, Output} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Teacher} from "../../../interfaces/Teacher";
import {TeachersService} from "../../../services/teachers.service";

@Component({
  selector: 'ip-editteacher',
  templateUrl: './editteacher.component.html',
  styleUrls: ['./editteacher.component.css']
})
export class EditteacherComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalEdit: ModalComponent;
  errorlength = false;
  private coruseUrl: string = "/api/teachers/";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  teacher: Teacher = new Teacher();
  courseid: any;

  constructor(private teachersService: TeachersService) {
  }

  ngOnInit() {
  }

  getCourse(url,id) {
    this.teachersService.getMember(url,id).subscribe((response) => {
      this.teacher = response;
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
    this.teachersService.updateMember(this.coruseUrl,this.teacher.id, this.teacher).subscribe(
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
