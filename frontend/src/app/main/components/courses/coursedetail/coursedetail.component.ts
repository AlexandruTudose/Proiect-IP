import { Component, OnInit } from '@angular/core';
import {TabSelected} from "../../../../common/components/tabs/TabSelected";
import {Tab} from "../../../../common/components/tabs/Tab";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'ip-coursedetail',
  templateUrl: './coursedetail.component.html',
  styleUrls: ['./coursedetail.component.css']
})
export class CoursedetailComponent implements OnInit {

  private selectedTab:TabSelected = new TabSelected(1);
  private tabs:Array<Tab> = [
    new Tab(1,"Proiecte","projects",this.courseSelected),
    new Tab(2,"Note","note",this.courseSelected),
    new Tab(3,"Teme","teme",this.courseSelected),
    new Tab(4,"Examene","examene",this.courseSelected)
  ];

  private courseSelected:number;

  constructor(private activatedRoute: ActivatedRoute, private _router: Router) {
    let params: any = this.activatedRoute.snapshot.params;
    this.courseSelected=params.id;
  }

  ngOnInit() {
  }

}
