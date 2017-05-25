import {Component, OnInit, ViewChild, EventEmitter, Output} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Course} from "../../../interfaces/Course";
import {MembersService} from "../../../services/members.service";
import {Student} from "../../../interfaces/Student";
import {Router} from "@angular/router";

@Component({
  selector: 'ip-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  @ViewChild(ModalComponent)
  modalEdit: ModalComponent;
  errorlength = false;
  private coruseUrl: string = "/api/students/";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  student: Student = new Student();
  courseid: any;

  constructor(private memberService: MembersService, public router: Router) {
    this.memberService = memberService;
    this.router = router;
  }

  ngOnInit() {
  }

  getCourse(url,id) {
    this.memberService.getMember(id).subscribe((response) => {
      this.student = response;
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
    this.memberService.updateMember(this.coruseUrl,this.courseid, this.student).subscribe(
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
