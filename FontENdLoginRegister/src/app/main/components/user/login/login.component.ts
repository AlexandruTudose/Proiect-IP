import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from 'ng2-bs3-modal/components/modal';
import {Course} from '../../../interfaces/Course';
import {MembersService} from '../../../services/members.service';
import {UserLog} from '../../../interfaces/UserLog';
import {Router} from '@angular/router';

@Component({
  selector: 'lp-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild(ModalComponent)
  errorlength = false;
  private loginUrl: String = 'http://localhost:5991/login';
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  userLog: UserLog = new UserLog();

  constructor(private memberService: MembersService, private router: Router) {
    this.memberService = memberService;
    this.router = router;
  }

  ngOnInit() {
  }

  loginUser() {
    this.login();
  }

  login() {
    this.memberService.loginUsr(this.loginUrl, this.userLog.email, this.userLog.password).subscribe(
      (succes) => {
        this.pageChanged.emit(true);
        this.router.navigate(<any>('/register'));
      },
      (error) => {
        this.err = true;
      },
      () => {
      }
    );
  }

}
