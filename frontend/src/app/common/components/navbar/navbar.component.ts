import {Component, OnInit, Input, Output, EventEmitter, AfterViewInit} from '@angular/core';

@Component({
  selector: 'lp-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentSidebar: any;
  @Output() settingsChanged = new EventEmitter();
  @Output() loggedOut = new EventEmitter();
  firstName = sessionStorage.getItem("firstName");
  lastName = sessionStorage.getItem("lastName");
  role = sessionStorage.getItem("role");

  constructor() { }

  ngOnInit() {
    this.currentSidebar = "default";
    this.firstName = sessionStorage.getItem("firstName");
    this.lastName = sessionStorage.getItem("lastName");
    this.role = sessionStorage.getItem("role");
  }

  logout() {
    this.loggedOut.emit(true);
}

}
