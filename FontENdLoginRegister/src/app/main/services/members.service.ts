import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Http, Response, Headers, RequestOptions, URLSearchParams} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import 'rxjs/add/operator/map';
import {SearchParams} from "../interfaces/SearchParams";


@Injectable()
export class MembersService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search:URLSearchParams;

  private getStudents = "/api/students";

  constructor(private http: Http) {
    this.http = http;
  }

  getList() : Observable<JsonObject> {
    return this.http.get(this.getStudents)
      .map((response: Response) => <JsonObject>response.json());
  }

  getListSimple(link:string) : Observable<JsonObject> {
    return this.http.get(link)
      .map((response: Response) => <JsonObject>response.json());
  }


  getMember(link, id) {
    return this.http.get(link + id)
      // .map((response: Response) => <JsonObject>response.json());
      .map(res => <any>res.json());
  }

  updateObject(link, postObject): Observable<any> {
    return this.http.post(link, JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }

  loginUsr(link, email, password): Observable<any> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('email', email);
    urlSearchParams.append('password', password);
    const body = urlSearchParams.toString();
    return this.http.post(link, body, new RequestOptions({headers: headers}))
      .map((response: Response) => <any>response);
  }

  validateEml(link, email, code): Observable<any> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('email', email);
    urlSearchParams.append('code', code);
    const body = urlSearchParams.toString();
    return this.http.post(link, body, new RequestOptions({headers: headers}))
      .map((response: Response) => <any>response);
  }

  registerUsr(link, postObject) : Observable<any> {
    return this.http.post(link, JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => <any>response);
  }



  updateMember(link, id, putObject) : Observable<any> {
    return this.http.put(link + id, JSON.stringify(putObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }

  deleteObject(link,id) : Observable<any> {
    return this.http.delete(link+"/"+id).map((response: Response) => response);
  }

  loginService(url,username,password) {
    var headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    let urlSearchParams = new URLSearchParams();
    urlSearchParams.append('username', username);
    urlSearchParams.append('password', password);
    let body = urlSearchParams.toString();
    return this.http.post(url,body, new RequestOptions({headers: headers}))
      .map((response: Response) => <any>response);
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
    console.log(this.search.toString());
  }

}
