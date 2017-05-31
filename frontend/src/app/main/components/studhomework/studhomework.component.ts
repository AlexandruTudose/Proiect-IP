import {Component, OnInit, ViewChild} from '@angular/core';
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {ProductSearch} from "../../interfaces/ProductSearch";
import {HomeworksService} from "../../services/homeworks.service";
import {CoursesService} from "../../services/courses.service";
import {ConfirmationComponent} from "../../../common/components/form/confirmation/confirmation.component";
import {NewhomeworkComponent} from "./newhomework/newhomework.component";
import {MembersService} from "../../services/members.service";
import {Router} from "@angular/router";

@Component({
  selector: 'ip-studhomework',
  templateUrl: './studhomework.component.html',
  styleUrls: ['./studhomework.component.css']
})
export class StudhomeworkComponent implements OnInit {

  @ViewChild(NewhomeworkComponent)
  modalAddMember: NewhomeworkComponent;
  @ViewChild(ConfirmationComponent)
  modalConfirm: ConfirmationComponent;
  // @ViewChild(EditcourseComponent)
  // modalEdit: EditcourseComponent;
  // @ViewChild(FindcourseComponent)
  // modalFind: FindcourseComponent;
  geturl = "/api/homeworks/";
  url = "/api/courses/";
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: ProductSearch = new ProductSearch();
  deleteId: number;
  id = sessionStorage.getItem("userId");

  homeworks: any;
  courses: any;
  succes = false;

  constructor(
    private homeworksService: HomeworksService,
    private coursesService: CoursesService,
    private memberService: MembersService,
    public router: Router
  ) {this.router = router;}


  ngOnInit() {
    this.getHomeworks();
  }



  getHomeworks() {
    this.homeworksService.getList(this.id).subscribe((response) => {
      this.homeworks = response.content;
      this.getCourses();
      this.getStudent();
    });
  }

  getStudent() {
    for (let i = 0; i < this.homeworks.length; i++) {
      this.memberService.getMember(this.homeworks[i].id_student).subscribe(
        (response) => {
          this.succes = true;
          this.homeworks[i].studentName = response.firstName + ' ' + response.lastName;
        });
      this.homeworksService.getMark(this.homeworks[i].id_nota).subscribe(
        (response) => {
          this.succes = true;
          this.homeworks[i].mark = response.valoare;
        }
      );
    }
  }

  getCourses() {
    this.coursesService.getList().subscribe((response) => {
      this.courses = response.content;
      for (let i = 0; i < this.homeworks.length; i++) {
        if (this.courses[0].id == this.homeworks[i].id_curs)
          this.homeworks[i].courseTitle = this.courses[0].denumire;
        if (this.courses[1].id == this.homeworks[i].id_curs)
          this.homeworks[i].courseTitle = this.courses[1].denumire;
      }
    });
  }


  sort(orderby: string) {
    if (this.searchParamas.sort[0] == orderby) {
      this.searchParamas.sort[1] = this.searchParamas.sort[1] == "asc" ? "desc" : "asc";
    } else {
      this.searchParamas.sort[1] = "asc";
      this.searchParamas.sort[0] = orderby;
    }
    // this.getMembers(this.searchurl);
  }

  handleDelete(confirm) {
    if (confirm == true) {
      this.homeworksService.deleteObject(this.geturl, this.deleteId).subscribe(
        (succes) => {
          console.log("sters");
          this.getHomeworks();
        },
        (error) => {
          console.log("nesters");
        },
        () => {
        }
      );
    }
  }

  handleAdd(confirm) {
    if (confirm == true)
      this.getHomeworks();
  }

  handleEdit(confirm) {
    if (confirm == true)
      this.getHomeworks();
  }

}
