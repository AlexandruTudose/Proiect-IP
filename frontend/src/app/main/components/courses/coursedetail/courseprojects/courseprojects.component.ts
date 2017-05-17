import {Component, OnInit, Input} from '@angular/core';
import {Project} from "../../../../interfaces/Project";

@Component({
  selector: 'ip-courseprojects',
  templateUrl: './courseprojects.component.html',
  styleUrls: ['./courseprojects.component.css']
})
export class CourseprojectsComponent implements OnInit {

  projects: Array<Project> = [
    new Project(1,"Proiect 1","Mica descriere","proiect1.zip"),
    new Project(2,"Proiect 2","Mica descriere","proiect2.zip"),
    new Project(3,"Proiect 3","Mica descriere","proiect3.zip"),
    new Project(4,"Proiect 4","Mica descriere","proiect4.zip"),
    new Project(5,"Proiect 5","Mica descriere","proiect5.zip")
  ];

  @Input() courseId: any;

  constructor() { }

  ngOnInit() {
  }

}
