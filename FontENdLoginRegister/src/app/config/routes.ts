/**
 * Created by ionut on 3/4/2017.
 */
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from '../main/components/user/login/login.component';

import {RegisterComponent} from '../main/components/user/register/register.component';

import {ValidateComponent} from '../main/components/user/validate/validate.component';
import {ResetpassComponent} from '../main/components/user/resetpass/resetpass.component';


export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login/reset', component: ResetpassComponent},
  {path: 'register/validate', component: ValidateComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}
   //{ path: '**', component: PageNotFoundComponent }
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
