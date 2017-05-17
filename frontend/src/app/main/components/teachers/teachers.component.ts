import {Component, OnInit, ViewChild} from '@angular/core';
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {ProductSearch} from "../../interfaces/ProductSearch";
import {TeachersService} from "../../services/teachers.service";
import {Router} from "@angular/router";
import {AddteacherComponent} from "./addteacher/addteacher.component";
import {EditteacherComponent} from "./editteacher/editteacher.component";
import {ConfirmationComponent} from "../../../common/components/form/confirmation/confirmation.component";
import {FindteacherComponent} from "./findteacher/findteacher.component";

@Component({
  selector: 'ip-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {
  @ViewChild(AddteacherComponent)
  modalMember: AddteacherComponent;
  @ViewChild(ConfirmationComponent)
  modalConfirm: ConfirmationComponent;
  @ViewChild(EditteacherComponent)
  modalEdit: EditteacherComponent;
  @ViewChild(FindteacherComponent)
  modalFind: FindteacherComponent;
  geturl = "/api/teachers/";
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: ProductSearch = new ProductSearch();
  deleteId: number;

  teachers: any;

  constructor(private teachersService: TeachersService, public router: Router) {
  }


  ngOnInit() {
    this.getCourses();
  }


  getCourses() {
    this.teachersService.getList().subscribe((response) => {
      this.teachers = response.content;
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
      this.teachersService.deleteObject(this.geturl, this.deleteId).subscribe(
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
