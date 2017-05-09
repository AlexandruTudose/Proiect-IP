import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { UtilizatoriComponent } from './admin/utilizatori/utilizatori.component';
import { AdminiComponent } from './admin/admini/admini.component';
import { OrarComponent } from './orar/orar.component';
import { CheckInsComponent } from './admin/check-ins/check-ins.component';
import { CereriInregistrareComponent } from './admin/cereri-inregistrare/cereri-inregistrare.component';
import { CereriModificareOrarComponent } from './admin/cereri-modificare-orar/cereri-modificare-orar.component';
import { AfisComponent } from './orar/afis/afis.component';
import { AdminOrarComponent } from './admin/admin-orar/admin-orar.component';

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
    AfisComponent,
    AdminOrarComponent,
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
        component: AdminOrarComponent
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
      },
      {
        path: 'orar',
        component: OrarComponent
      },
      {
        path: 'orar/afis',
        component: AfisComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
