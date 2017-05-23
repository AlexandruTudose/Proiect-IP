import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {MembersService} from "../../../services/members.service";

@Component({
  selector: 'ip-admin-orar',
  templateUrl: './admin-orar.component.html',
  styleUrls: ['./admin-orar.component.css']
})
export class AdminOrarComponent implements OnInit {

  private urlAdminOrar = '/api/v1/orar/crud/read';
  orar: any;

  constructor(private orarService: MembersService, private router: Router) {
    this.orarService = orarService;
    this.router = router;
  }

  ngOnInit() {
    this.getOrar();
  }

  getOrar() {
    this.orarService.getList(this.urlAdminOrar).subscribe((response) => {
      this.orar = response;
    });
  }

}
