import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Course} from "../../../interfaces/Course";
import {MembersService} from "../../../services/members.service";
import {Student} from "../../../interfaces/Student";
import {Router} from "@angular/router";

@Component({
  selector: 'ip-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalMember: ModalComponent;
  student: Student = new Student();
  errorlength = false;
  private addCourseUrl: string = "/api/students";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  constructor(private memberService: MembersService, public router: Router) {
    this.memberService = memberService;
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
    this.memberService.updateObject(this.addCourseUrl, this.student).subscribe(
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
