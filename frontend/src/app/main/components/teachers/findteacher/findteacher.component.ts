import {Component, OnInit, ViewChild, EventEmitter, Output} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Teacher} from "../../../interfaces/Teacher";
import {TeachersService} from "../../../services/teachers.service";

@Component({
  selector: 'ip-findteacher',
  templateUrl: './findteacher.component.html',
  styleUrls: ['./findteacher.component.css']
})
export class FindteacherComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalFind: ModalComponent;
  errorlength = false;
  private getUrl: string = "/api/teachers/";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  errorfind = false;
  succes = false;

  teacher: Teacher = new Teacher();
  searchteacher: any;
  teacherid: any;

  constructor(private teachersService: TeachersService) {
  }

  ngOnInit() {
  }

  getstudent(url,id) {
    this.teachersService.getMember(url,id).subscribe(
      (succes) => {
        this.succes = true;
        this.errorfind = false;
        this.getstudentDetails(this.getUrl,this.searchteacher);
      },
      (error) => {
        this.succes = false;
        this.errorfind = true;
      }
    );
  }

  getstudentDetails(url,id) {
    this.teachersService.getMember(url,id).subscribe(
      (response) => {
        this.teacher = response;
      }
    );
  }

  open(id) {
    this.err = false;
    this.teacherid = id;
    this.modalFind.open();
  }

  close() {
    this.modalFind.close();
  }

  addObject() {
    this.getstudent(this.getUrl,this.searchteacher);
  }

  addMember() {
    this.teachersService.updateObject(this.getUrl, this.teacher).subscribe(
      (succes) => {
        this.modalFind.close();
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
