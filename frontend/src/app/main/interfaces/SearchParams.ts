/**
 * Created by Lenovo on 3/20/2017.
 */
export class SearchParams{
  page:number = 0;
  size:number = 10;
  sort:Array<string> = ["id","asc"];
  search:any;
}
