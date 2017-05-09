import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { UtilizatoriComponent } from './admin/utilizatori/utilizatori.component';
import { AdminiComponent } from './admin/admini/admini.component';
import { OrarComponent } from './admin/orar/orar.component';
import { CheckInsComponent } from './admin/check-ins/check-ins.component';
import { CereriInregistrareComponent } from './admin/cereri-inregistrare/cereri-inregistrare.component';
import { CereriModificareOrarComponent } from './admin/cereri-modificare-orar/cereri-modificare-orar.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    UtilizatoriComponent,
    AdminiComponent,
    OrarComponent,
    CheckInsComponent,
    CereriInregistrareComponent,
    CereriModificareOrarComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path: 'admin',
        component: AdminComponent
      },
      {
        path: 'admin/users',
        component: UtilizatoriComponent
      },
      {
        path: 'admin/admins',
        component: AdminiComponent
      },
      {
        path: 'admin/orar',
        component: OrarComponent
      },
      {
        path: 'admin/check-ins',
        component: CheckInsComponent
      },
      {
        path: 'admin/register-request',
        component: CereriInregistrareComponent
      },
      {
        path: 'admin/schedule-request',
        component: CereriModificareOrarComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
