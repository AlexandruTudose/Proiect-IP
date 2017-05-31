import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {Router} from "@angular/router";

@Component({
  selector: 'lp-resetpass',
  templateUrl: './resetpass.component.html',
  styleUrls: ['./resetpass.component.css']
})
export class ResetpassComponent implements OnInit {

  email: string;
  private resetUrl= 'http://localhost:5991/login/reset';
  @Output() pageChanged = new EventEmitter();
  err: boolean;


  constructor(private userService: UserService, private router: Router) {
    this.userService = userService;
    this.router = router;
  }

  ngOnInit() {
  }

  resetPassword(){
    this.reset();
  }

  reset() {
    this.userService.resetPass(this.resetUrl, this.email).subscribe(
      (succes) => {
        this.err= false;
      },
      (error) => {
        this.err = true;
      },
      () => {
      }
    );
  }

}
