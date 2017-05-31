import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from 'ng2-bs3-modal/components/modal';
import {Course} from '../../../interfaces/Course';
import {MembersService} from '../../../services/members.service';
import {UserLog} from '../../../interfaces/UserLog';
import {Router} from '@angular/router';
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'lp-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild(ModalComponent)
  errorlength = false;
  private loginUrl: String = '/api/login';
  @Output() isLogged = new EventEmitter();
  @Output() userInfo = new EventEmitter();
  @Output() register = new EventEmitter();
  err: boolean;

  user: any;
  userLog: UserLog = new UserLog();

  constructor(private userService: UserService, private router: Router) {
    this.userService = userService;
    this.router = router;
  }

  ngOnInit() {
  }

  loginUser() {
    this.login();
  }

  login() {
    this.err = false;
    this.userService.loginUsr(this.loginUrl, this.userLog.email, this.userLog.password).subscribe(
      (response) => {
        let id = response._body;
        if(id != null) {
        this.isLogged.emit(true);
        this.userInfo.emit(id);
        this.getUser(id);
        }
        else {
          this.userInfo.emit(false);
          this.err = true;
        }
      },
      (error) => {
        console.log("test");
        this.err = true;
      },
      () => {
      }
    );
  }

  getUser(userId) {
    this.userService.getMember(userId).subscribe(
      (response) => {
        this.user = response;
        sessionStorage.setItem("firstName",this.user.firstName);
        sessionStorage.setItem("lastName",this.user.lastName);
        sessionStorage.setItem("role",this.user.role);
        sessionStorage.setItem("userId",this.user.id);
      }
    )
  }

  goRegister(){
    this.register.emit(true);
  }

}
