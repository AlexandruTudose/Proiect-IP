/**
 * Created by Lenovo on 3/16/2017.
 */
export class PagerObject {
  page:number = 0;
  rows:number = 10;
  totalElements:number=0;
  totalPages:number=0;
  chooseRowsOnPage:Array<number>=[1,10,30,90,180,270,550];
}
