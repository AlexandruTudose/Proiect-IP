import {Component, OnInit, ViewChild} from '@angular/core';
import {MembersService} from "../../../services/members.service";
import {Router} from "@angular/router";
import {ConfirmationComponent} from "../../../../common/components/form/confirmation/confirmation.component";

@Component({
  selector: 'ip-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {

  @ViewChild(ConfirmationComponent)
  modalConfirm: ConfirmationComponent;

  private urlAdminUsers = '/api/v1/users';
  users: any;
  deleteId: number;

  constructor(private memberService: MembersService, private router: Router) {
    this.memberService = memberService;
    this.router = router;
  }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.memberService.getList(this.urlAdminUsers).subscribe((response) => {
      this.users = response;
    });
  }

  userDelete(id) {
    this.deleteId = id;
  }

  handleDelete(confirm) {
    if (confirm == true) {
      this.memberService.deleteObject(this.urlAdminUsers, this.deleteId).subscribe(
        (succes) => {
          console.log("User sters cu succes!");
          this.getUsers();
        },
        (error) => {
          console.log("User nu a fost sters! A aparut o erroare.");
        },
        () => {
        }
      );
    }
  }

}
