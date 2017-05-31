import { Component, OnInit } from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {MossService} from "../../services/moss.service";
import {Moss} from "../../interfaces/Moss";
import {SearchParams} from "../../interfaces/SearchParams";
import {ProductSearch} from "../../interfaces/ProductSearch";

@Component({
  selector: 'ip-moss',
  templateUrl: './moss.component.html',
  styleUrls: ['./moss.component.css']
})
export class MossComponent implements OnInit {

  courses: any;
  moss: Moss = new Moss();
  url: any;
  loaded = false;
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: ProductSearch = new ProductSearch();

  constructor(private coursesService: CoursesService, private mossService: MossService) { }

  ngOnInit() {
    this.getCourses();
    this.searchObject.path2 = this.moss.path2;
    this.searchParamas.search = this.searchObject;
  }

  getCourses() {
    this.coursesService.getList().subscribe((response) => {
      this.courses = response.content;
    });
  }

  chooseCourse(denumire) {
    this.loaded = false;
    this.moss.path1 = 'D:\\teme\\' + denumire;
    this.searchObject.path1 = this.moss.path1;
    this.searchParamas.search = this.searchObject;

  }

  getMoss() {
    this.loaded = false;
    this.searchObject.language = this.moss.language;
    this.searchParamas.search = this.searchObject;
    console.log(this.searchParamas);
    this.mossService.getMoss(this.searchParamas).subscribe(
      (response) => {
        this.loaded = true;
        this.url = response._body;
      }
    );
  }

}
