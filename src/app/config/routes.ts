/**
 * Created by ionut on 3/4/2017.
 */
import {Routes, RouterModule}  from '@angular/router';

import {StudentsComponent} from "../main/components/students/students.component";

export const routes: Routes = [
  {path: 'students', component: StudentsComponent},
  {path: '', redirectTo: '/students', pathMatch: 'full'}
  // { path: '**', component: PageNotFoundComponent }
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
