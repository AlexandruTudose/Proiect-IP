import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Http, Response, Headers, RequestOptions, URLSearchParams} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import 'rxjs/add/operator/map';
import {SearchParams} from "../interfaces/SearchParams";


@Injectable()
export class OrarService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlGetOrar = "/api/v1/orar/crud/read";

  constructor(private http: Http) {
    this.http = http;
  }

  getList(): Observable<JsonObject> {
    return this.http.get(this.urlGetOrar)
      .map((response: Response) => <JsonObject>response.json());
  }

  deleteObject(link,id) : Observable<any> {
    return this.http.delete(link+"/"+id).map((response: Response) => response);
  }

  getMember(link, id: number) {
    return this.http.get(link + id)
      .map(res => <any>res.json());
  }

  updateObject(link,postObject) : Observable<any> {
    return this.http.post(link,JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }

  updateMember(link,id,putObject) : Observable<any> {
    return this.http.put(link + id,JSON.stringify(putObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }
}
