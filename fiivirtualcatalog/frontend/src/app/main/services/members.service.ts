import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Http, Response, Headers, RequestOptions, URLSearchParams} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import 'rxjs/add/operator/map';


@Injectable()
export class MembersService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search:URLSearchParams;

  constructor(private http: Http) {
    this.http = http;
  }

  getList(link:string) : Observable<JsonObject> {
    return this.http.get(link)
      .map((response: Response) => <JsonObject>response.json());
  }

  deleteObject(link,id) : Observable<any> {
    return this.http.delete(link+"/"+id).map((response: Response) => response);
  }

}

