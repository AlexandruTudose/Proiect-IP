/**
 * Created by ionut on 3/4/2017.
 */
import {Routes, RouterModule}  from '@angular/router';

import {StudentsComponent} from "../main/components/students/students.component";

import {LoginComponent} from "../main/components/user/login/login.component";

import {RegisterComponent} from "../main/components/user/register/register.component";

import {ValidateComponent} from "../main/components/user/validate/validate.component";


export const routes: Routes = [
  {path: 'students', component: StudentsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'register/validate', component: ValidateComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}
  // { path: '**', component: PageNotFoundComponent }
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
