/**
 * Created by ionut on 3/4/2017.
 */
import {Routes, RouterModule}  from '@angular/router';

import {StudentsComponent} from "../main/components/students/students.component";
import {TeachersComponent} from "../main/components/teachers/teachers.component";
import {CoursesComponent} from "../main/components/courses/courses.component";
import {CoursedetailComponent} from "../main/components/courses/coursedetail/coursedetail.component";
import {StudhomeworkComponent} from "../main/components/studhomework/studhomework.component";
import {TeacherhomeworkComponent} from "../main/components/teacherhomework/teacherhomework.component";
import {AddmarkComponent} from "../main/components/teacherhomework/addmark/addmark.component";

export const routes: Routes = [
  {path: 'teachers', component: TeachersComponent},
  {path: 'students', component: StudentsComponent},
  {path: 'courses', component: CoursesComponent},
  {path: 'courses/:id', component: CoursedetailComponent},
  {path: 'homeworkstud', component: StudhomeworkComponent},
  {path: 'homeworkteacher', component: TeacherhomeworkComponent},
  {path: 'homeworkteacher/:id', component: AddmarkComponent},
  {path: '', redirectTo: '/courses', pathMatch: 'full'}
  // { path: '**', component: PageNotFoundComponent }
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
