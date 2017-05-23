import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Http, Response, Headers, RequestOptions, URLSearchParams, ResponseContentType} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import 'rxjs/add/operator/map';
import {SearchParams} from "../interfaces/SearchParams";
import {environment} from "../../../environments/environment";


@Injectable()
export class HomeworksService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search:URLSearchParams;

  private addHomeworkUrl = "/api/homeworks/";
  private getHomeworksUrl = "/api/homeworks/student/";
  private getMarkUrl = "/api/marks/";

  constructor(private http: Http) {
    this.http = http;
  }

  getList(id_stud) : Observable<JsonObject> {
    return this.http.get(this.getHomeworksUrl + id_stud)
      .map((response: Response) => <JsonObject>response.json());
  }

  getHomeworks() : Observable<JsonObject> {
    return this.http.get(this.addHomeworkUrl)
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

  getMark(id) {
    return this.http.get(this.getMarkUrl + id)
    // .map((response: Response) => <JsonObject>response.json());
      .map(res => <any>res.json());
  }

  addHomework(postObject) : Observable<any> {
    return this.http.post(this.addHomeworkUrl,JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }

  updateMark(id,mark) : Observable<any> {
    return this.http.put(this.getMarkUrl + id,JSON.stringify(mark),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }

  deleteObject(link,id) : Observable<any> {
    return this.http.delete(link+"/"+id).map((response: Response) => response);
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
