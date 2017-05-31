import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from 'ng2-bs3-modal/components/modal';
import {MembersService} from '../../../services/members.service';
import {UserService} from '../../../services/user.service';
import {Router} from "@angular/router";
@Component({
  selector: 'ip-validate',
  templateUrl: './validate.component.html',
  styleUrls: ['./validate.component.css']
})
export class ValidateComponent implements OnInit {

  code: string;
  email: string;
  errorlength = false;
  private validateUrl= '/api/register/validate';
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  constructor(private userService: UserService, private router: Router) {
    this.userService = userService;
    this.router = router;
  }

  ngOnInit() {
  }

  validateEmail(){
    this.validate();
  }
  validate() {
    this.userService.validateEml(this.validateUrl, this.email, this.code).subscribe(
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
