/**
 * Created by Daniel on 5/16/2017.
 */
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";

@Injectable()
export class UploadService {

  private uploadUrl:string = "/api/homeworks";
  public progress:Observable<any>;
  public progressObserver:any;

  public uploadProductsImages(homeworkId:number,files: FileList): Observable<any> {
    return Observable.create(observer => {
      let formData: FormData = new FormData(), xhr: XMLHttpRequest = new XMLHttpRequest();
      for (let i = 0; i < files.length; i++) {
        formData.append("files", files[i], files[i].name);
      }

      xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
          if (xhr.status === 200) {
            observer.next(JSON.parse(xhr.response));
            observer.complete();
          } else {
            observer.error(xhr.response);
          }
        }
      };

      xhr.upload.onprogress = (event) => {
        this.progressObserver.next(Math.round(event.loaded / event.total * 100));
      };

      xhr.open('POST', this.uploadUrl.concat("/"+homeworkId+"/upload"), true);
      xhr.send(formData);
    });
  }

}
