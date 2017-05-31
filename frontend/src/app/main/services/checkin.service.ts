import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Http, Response, Headers, RequestOptions, URLSearchParams} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import 'rxjs/add/operator/map';
import {SearchParams} from "../interfaces/SearchParams";


@Injectable()
export class CheckinService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search:URLSearchParams;

  private getCheckins = "/api/v1/checkins/";
  private getStudCheckins = "/api/v1/checkins/register/";

  constructor(private http: Http) {
    this.http = http;
  }

  getList() : Observable<JsonObject> {
    return this.http.get(this.getCheckins)
      .map((response: Response) => <JsonObject>response.json());
  }

  addCheckin(postObject) : Observable<any> {
    return this.http.post(this.getCheckins,JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }

  joinCheckin(postObject,id) : Observable<any> {
    return this.http.post(this.getStudCheckins + id,JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }



}
