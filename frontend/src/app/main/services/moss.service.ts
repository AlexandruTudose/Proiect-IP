import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Http, Response, Headers, RequestOptions, URLSearchParams} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import 'rxjs/add/operator/map';
import {SearchParams} from "../interfaces/SearchParams";


@Injectable()
export class MossService {
  private headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
  private search = new URLSearchParams();

  private getMossEP = "/api/profesor/moss/";

  constructor(private http: Http) {
    this.http = http;
  }

  getMoss(searchParamas:SearchParams) : Observable<any> {
    this.search.append('path1',searchParamas.search.path1);
    this.search.append('path2',searchParamas.search.path2);
    this.search.append('language',searchParamas.search.language);
    let body = this.search.toString();
    return this.http.post(this.getMossEP,body,new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }

  private setSearch(searchParamas:SearchParams):void{
    this.search = new URLSearchParams();
    this.search.set("page",searchParamas.page.toString());
    this.search.set("size",searchParamas.size.toString());
    this.search.set("sort",searchParamas.sort.toString());
    for (let key in searchParamas.search) {
      if (searchParamas.search.hasOwnProperty(key)) {
        let val = searchParamas.search[key];
        this.search.set(key, val);
      }
    }
  }


}
