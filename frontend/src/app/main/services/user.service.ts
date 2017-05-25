import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Http, Response, Headers, RequestOptions, URLSearchParams} from '@angular/http';
import {JsonObject} from '../interfaces/JsonObject';
import 'rxjs/add/operator/map';
import {SearchParams} from '../interfaces/SearchParams';


@Injectable()
export class UserService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;


  constructor(private http: Http) {
    this.http = http;
  }

  resetPass(link, email): Observable<any> {
    return this.http.post(link, JSON.stringify(email),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => <any>response);
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


}
