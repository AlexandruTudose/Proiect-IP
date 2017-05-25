import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Course} from "../../../interfaces/Course";
import {CoursesService} from "../../../services/courses.service";
import {Router} from "@angular/router";

@Component({
  selector: 'ip-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalMember: ModalComponent;
  course: Course = new Course();
  errorlength = false;
  private addCourseUrl: string = "/api/courses";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  constructor(private coursesService: CoursesService, public router: Router) {
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
    this.coursesService.updateObject(this.addCourseUrl, this.course).subscribe(
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
