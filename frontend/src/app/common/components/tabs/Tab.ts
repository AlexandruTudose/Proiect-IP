/**
 * Created by Lenovo on 3/20/2017.
 */
export class Tab{
  tabid: number;
  name:string;
  taburl: string;
  userid: number;

  constructor(id:number,name:string,url:string,userid: number){
    this.tabid = id;
    this.name = name;
    this.taburl = url;
    this.userid = userid;
  }

}
