import {Component, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'ip-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  @Output() isLogged = new EventEmitter();
  @Output() userInfo = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

}
