/**
 * Created by Daniel on 4/23/2017.
 */
export class Project {
  id: number;
  title: string;
  content: string;
  file: string;

  constructor(id, title, content, file) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.file = file;
  }
}
