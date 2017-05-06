import {Sort} from "./Sort";
/**
 * Created by Lenovo on 3/16/2017.
 */
export class JsonObject {
  content: Array<any>;
  totalPages: number;
  totalElements: number;
  last: boolean;
  size: number;
  number: number;
  sort: Sort;
}
