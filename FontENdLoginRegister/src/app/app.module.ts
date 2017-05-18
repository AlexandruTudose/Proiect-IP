import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SidebarComponent } from './common/components/sidebar/sidebar.component';

import {MembersService} from './main/services/members.service';
import { KeysPipe } from './main/pipes/keys.pipe';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';
import { routing, appRoutingProviders } from './config/routes';
import {LoginComponent} from './main/components/user/login/login.component';
import {RegisterComponent} from './main/components/user/register/register.component';
import {ValidateComponent} from './main/components/user/validate/validate.component';
import { ResetpassComponent } from './main/components/user/resetpass/resetpass.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    KeysPipe,
    LoginComponent,
    ValidateComponent,
    RegisterComponent,
    ResetpassComponent
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
