
import {Routes, RouterModule}  from '@angular/router';

import {AdminUsersComponent} from "../main/components/admin/admin-users/admin-users.component";
import {AdminOrarComponent} from "../main/components/admin/admin-orar/admin-orar.component";

export const routes: Routes = [
  {path: 'admin/users', component: AdminUsersComponent},
  {path: '', redirectTo: '/admin/users', pathMatch: 'full'},
  {path: 'admin/orar', component: AdminOrarComponent},
  {path: '', redirectTo: '/orar', pathMatch: 'full'}
  // { path: '**', component: PageNotFoundComponent }
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
