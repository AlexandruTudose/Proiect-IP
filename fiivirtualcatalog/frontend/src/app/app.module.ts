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
import {AdminUsersComponent} from "./main/components/admin/admin-users/admin-users.component";
import {AdminOrarComponent} from "./main/components/admin/admin-orar/admin-orar.component";

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    KeysPipe,
    ConfirmationComponent,
    AdminUsersComponent,
    AdminOrarComponent
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
