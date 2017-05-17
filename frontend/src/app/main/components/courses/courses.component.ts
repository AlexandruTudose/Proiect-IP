import {Component, OnInit, ViewChild} from '@angular/core';
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {ProductSearch} from "../../interfaces/ProductSearch";
import {CoursesService} from "../../services/courses.service";
import {AddcourseComponent} from "./addcourse/addcourse.component";
import {EditcourseComponent} from "./editcourse/editcourse.component";
import {ConfirmationComponent} from "../../../common/components/form/confirmation/confirmation.component";
import {FindcourseComponent} from "./findcourse/findcourse.component";

@Component({
  selector: 'ip-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  @ViewChild(AddcourseComponent)
  modalMember: AddcourseComponent;
  @ViewChild(ConfirmationComponent)
  modalConfirm: ConfirmationComponent;
  @ViewChild(EditcourseComponent)
  modalEdit: EditcourseComponent;
  @ViewChild(FindcourseComponent)
  modalFind: FindcourseComponent;
  geturl = "/api/teachers/";
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: ProductSearch = new ProductSearch();
  deleteId: number;

  courses: any;

  constructor(private coursesService: CoursesService) {
  }


  ngOnInit() {
    this.getCourses();
  }


  getCourses() {
    this.coursesService.getList().subscribe((response) => {
      this.courses = response.content;
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

  memberDelete(id) {
    this.deleteId = id;
  }

  handleDelete(confirm) {
    if (confirm == true) {
      this.coursesService.deleteObject(this.geturl, this.deleteId).subscribe(
        (succes) => {
          console.log("sters");
          this.getCourses();
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
    if(confirm == true)
      this.getCourses();
  }

  handleEdit(confirm) {
    if(confirm == true)
      this.getCourses();
  }
}
