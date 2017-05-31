import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'ip-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  role = sessionStorage.getItem("role");

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges() {
  }

  changeHome() {
  }

}
