import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SidebarComponent } from './common/components/sidebar/sidebar.component';

import {MembersService} from "./main/services/members.service";
import { KeysPipe } from './main/pipes/keys.pipe';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';
import { ConfirmationComponent } from './common/components/form/confirmation/confirmation.component';
import { routing, appRoutingProviders } from './config/routes';
import { StudentsComponent } from './main/components/students/students.component';
import { AddComponent } from './main/components/students/add/add.component';
import { EditComponent } from './main/components/students/edit/edit.component';
import { FindComponent } from './main/components/students/find/find.component';
import {LoginComponent} from './main/components/user/login/login.component';
import {RegisterComponent} from './main/components/user/register/register.component';
import {ValidateComponent} from './main/components/user/validate/validate.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    KeysPipe,
    ConfirmationComponent,
    StudentsComponent,
    AddComponent,
    EditComponent,
    FindComponent,
    LoginComponent,
    ValidateComponent,
    RegisterComponent
  ],
  imports: [
    Ng2Bs3ModalModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    routing
  ],
  providers: [
    MembersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
