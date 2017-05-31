/**
 * Created by ionut on 3/4/2017.
 */
import {Routes, RouterModule} from '@angular/router';

import {UsersComponent} from '../main/components/students/users.component';
import {CoursesComponent} from '../main/components/courses/courses.component';
import {CoursedetailComponent} from '../main/components/courses/coursedetail/coursedetail.component';
import {StudhomeworkComponent} from '../main/components/studhomework/studhomework.component';
import {TeacherhomeworkComponent} from '../main/components/teacherhomework/teacherhomework.component';
import {AddmarkComponent} from '../main/components/teacherhomework/addmark/addmark.component';
import {LoginComponent} from '../main/components/user/login/login.component';
import {RegisterComponent} from '../main/components/user/register/register.component';
import {ValidateComponent} from '../main/components/user/validate/validate.component';
import {ResetpassComponent} from '../main/components/user/resetpass/resetpass.component';
import {HomeComponent} from "../main/components/home/home.component";
import {TeachercheckinComponent} from "../main/components/teachercheckin/teachercheckin.component";
import {MossComponent} from "../main/components/moss/moss.component";
import {StudcheckinComponent} from "../main/components/studcheckin/studcheckin.component";

export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'login/reset', component: ResetpassComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'register/validate', component: ValidateComponent},
  {path: 'students', component: UsersComponent},
  {path: 'checkinteacher', component: TeachercheckinComponent},
  {path: 'checkinstudent', component: StudcheckinComponent},
  {path: 'courses', component: CoursesComponent},
  {path: 'moss', component: MossComponent},
  {path: 'home', component: HomeComponent},
  {path: 'courses/:id', component: CoursedetailComponent},
  {path: 'homeworkstud', component: StudhomeworkComponent},
  {path: 'homeworkteacher', component: TeacherhomeworkComponent},
  {path: 'homeworkteacher/:id', component: AddmarkComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
  // { path: '**', component: PageNotFoundComponent }
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
