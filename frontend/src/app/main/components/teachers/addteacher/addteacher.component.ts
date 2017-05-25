import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Teacher} from "../../../interfaces/Teacher";
import {TeachersService} from "../../../services/teachers.service";
import {Router} from "@angular/router";

@Component({
  selector: 'ip-addteacher',
  templateUrl: './addteacher.component.html',
  styleUrls: ['./addteacher.component.css']
})
export class AddteacherComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalMember: ModalComponent;
  teacher: Teacher = new Teacher();
  errorlength = false;
  private addCourseUrl: string = "/api/teachers";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  constructor(private teachersService: TeachersService, public router: Router) {
    this.router = router;
  }

  ngOnInit() {
  }


  open() {
    this.err = false;
    this.modalMember.open();
  }

  close() {
    this.modalMember.close();
  }

  addObject() {
    this.addMember();
  }

  addMember() {
    this.teachersService.updateObject(this.addCourseUrl, this.teacher).subscribe(
      (succes) => {
        this.modalMember.close();
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
