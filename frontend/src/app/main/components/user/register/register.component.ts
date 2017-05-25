import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Course} from "../../../interfaces/Course";
import {MembersService} from "../../../services/members.service";
import {User} from "../../../interfaces/User";
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";
@Component({
  selector: 'ip-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  @ViewChild(ModalComponent)
  modalMember: ModalComponent;
  user: User = new User();

  errorlength = false;
  private registerUrl: string = "http://localhost:5991/register";
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  constructor(private userService: UserService, private router: Router) {
    this.userService = userService;
    this.router = router;
  }

  ngOnInit() {
  }

  registerUser() {
    this.register();
  }

  register() {
    this.userService.registerUsr(this.registerUrl, this.user).subscribe(
      (succes) => {
        this.router.navigateByUrl('/register/validate');
      },
      (error) => {
        this.err = true;
      },
      () => {
      }
    );
  }

}
