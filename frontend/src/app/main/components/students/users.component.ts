import {Component, OnInit, ViewChild} from '@angular/core';
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {ProductSearch} from "../../interfaces/ProductSearch";
import {MembersService} from "../../services/members.service";
import {Router} from "@angular/router";
import {ConfirmationComponent} from "../../../common/components/form/confirmation/confirmation.component";
import {AddComponent} from "./add/add.component";
import {EditComponent} from "./edit/edit.component";
import {FindComponent} from "./find/find.component";

@Component({
  selector: 'ip-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  @ViewChild(AddComponent)
  modalMember: AddComponent;
  @ViewChild(ConfirmationComponent)
  modalConfirm: ConfirmationComponent;
  @ViewChild(EditComponent)
  modalEdit: EditComponent;
  @ViewChild(FindComponent)
  modalFind: FindComponent;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: ProductSearch = new ProductSearch();
  deleteId: number;

  users: any;

  @ViewChild('filter') filterInput: any;
  private filterObs: any;

  constructor(private memberService: MembersService, public router: Router) {
    this.router = router;
  }


  ngOnInit() {
    this.getStudents();
  }


  getStudents() {
    this.memberService.getList().subscribe((response) => {
      this.users = response;
    });
  }

  getMemberID(id) {
    this.router.navigate(['/editmember', id]);
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
      this.memberService.deleteObject(this.deleteId).subscribe(
        (succes) => {
          console.log("sters");
          this.getStudents();
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
    // this.searchParamas.page = this.pager.page;
    // this.searchParamas.size = this.pager.rows;
    // console.log(this.searchParamas);
    if(confirm == true)
      this.getStudents();
  }

  handleEdit(confirm) {
    if(confirm == true)
      this.getStudents();
  }
}
