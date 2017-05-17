import {Component, OnInit, ViewChild, EventEmitter, Output} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Course} from "../../../interfaces/Course";
import {CoursesService} from "../../../services/courses.service";

@Component({
  selector: 'ip-findcourse',
  templateUrl: './findcourse.component.html',
  styleUrls: ['./findcourse.component.css']
})
export class FindcourseComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalFind: ModalComponent;
  errorlength = false;
  private getUrl: string = "/api/courses/";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  errorfind = false;
  succes = false;

  course: Course = new Course();
  searchcourse: any;
  courseid: any;

  constructor(private coursesService: CoursesService) {
  }

  ngOnInit() {
  }

  getstudent(url,id) {
    this.coursesService.getMember(url,id).subscribe(
      (succes) => {
        this.succes = true;
        this.errorfind = false;
        this.getstudentDetails(this.getUrl,this.searchcourse);
      },
      (error) => {
        this.succes = false;
        this.errorfind = true;
      }
    );
  }

  getstudentDetails(url,id) {
    this.coursesService.getMember(url,id).subscribe(
      (response) => {
        this.course = response;
      }
    );
  }

  open(id) {
    this.err = false;
    this.courseid = id;
    this.modalFind.open();
  }

  close() {
    this.modalFind.close();
  }

  addObject() {
    this.getstudent(this.getUrl,this.searchcourse);
  }

  addMember() {
    this.coursesService.updateObject(this.getUrl, this.course).subscribe(
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
