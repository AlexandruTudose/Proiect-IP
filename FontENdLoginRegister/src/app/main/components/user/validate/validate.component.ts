import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {MembersService} from '../../../services/members.service';
@Component({
  selector: 'ip-validate',
  templateUrl: './validate.component.html',
  styleUrls: ['./validate.component.css']
})
export class ValidateComponent implements OnInit {

  code: string;
  email: string;
  errorlength = false;
  private validateUrl= 'http://localhost:5991/register/validate';
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  constructor(private memberService: MembersService) {
    this.memberService = memberService;
  }

  ngOnInit() {
  }

  validateEmail(){
    this.validate();
  }
  validate() {
    this.memberService.validateEml(this.validateUrl, this.email, this.code).subscribe(
      (succes) => {
        this.pageChanged.emit(true);
      },
      (error) => {
        this.err = true;
      },
      () => {
      }
    );
  }

}
