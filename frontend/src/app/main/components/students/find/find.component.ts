import {Component, OnInit, ViewChild, EventEmitter, Output} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {MembersService} from "../../../services/members.service";
import {Student} from "../../../interfaces/Student";
import {Router} from "@angular/router";
import {User} from "../../../interfaces/User";

@Component({
  selector: 'ip-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {


  @ViewChild(ModalComponent)
  modalFind: ModalComponent;
  errorlength = false;
  private getUrl: string = "/api/students/";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  errorfind = false;
  succes = false;

  user: User = new User();
  searchstudent: any;
  studentid: any;

  constructor(private memberService: MembersService, public router: Router) {
    this.memberService = memberService;
    this.router = router;
  }

  ngOnInit() {
  }

  getstudent(url,id) {
    this.memberService.getMember(id).subscribe(
      (succes) => {
        this.succes = true;
        this.errorfind = false;
        this.getstudentDetails(this.getUrl,this.searchstudent);
      },
      (error) => {
        this.succes = false;
        this.errorfind = true;
      }
    );
  }

  getstudentDetails(url,id) {
    this.memberService.getMember(id).subscribe(
      (response) => {
        this.user = response;
      }
    );
  }

  open(id) {
    this.err = false;
    this.studentid = id;
    this.modalFind.open();
  }

  close() {
    this.modalFind.close();
  }

  addObject() {
    this.getstudent(this.getUrl,this.searchstudent);
  }
}
