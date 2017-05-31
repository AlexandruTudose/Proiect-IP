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
import { ConfirmationComponent } from './common/components/form/confirmation/confirmation.component';
import { routing, appRoutingProviders } from './config/routes';
import { UsersComponent } from './main/components/students/users.component';
import { AddComponent } from './main/components/students/add/add.component';
import { EditComponent } from './main/components/students/edit/edit.component';
import { FindComponent } from './main/components/students/find/find.component';
import {TeachersService} from './main/services/teachers.service';
import { CoursesComponent } from './main/components/courses/courses.component';
import {CoursesService} from './main/services/courses.service';
import { AddcourseComponent } from './main/components/courses/addcourse/addcourse.component';
import { EditcourseComponent } from './main/components/courses/editcourse/editcourse.component';
import { FindcourseComponent } from './main/components/courses/findcourse/findcourse.component';
import { CoursedetailComponent } from './main/components/courses/coursedetail/coursedetail.component';
import { TabsComponent } from './common/components/tabs/tabs.component';
import { CourseprojectsComponent } from './main/components/courses/coursedetail/courseprojects/courseprojects.component';
import { StudhomeworkComponent } from './main/components/studhomework/studhomework.component';
import {HomeworksService} from './main/services/homeworks.service';
import {UploadService} from './main/services/UploadService';
import { NewhomeworkComponent } from './main/components/studhomework/newhomework/newhomework.component';
import { TeacherhomeworkComponent } from './main/components/teacherhomework/teacherhomework.component';
import { AddmarkComponent } from './main/components/teacherhomework/addmark/addmark.component';
import {LoginComponent} from './main/components/user/login/login.component';
import {ResetpassComponent} from './main/components/user/resetpass/resetpass.component';
import {ValidateComponent} from './main/components/user/validate/validate.component';
import {RegisterComponent} from './main/components/user/register/register.component';
import {UserService} from './main/services/user.service';
import {Sidebar2Component} from './common/components/sidebar2/sidebar2.component';
import {NavbarComponent} from "./common/components/navbar/navbar.component";
import { UserComponent } from './main/components/user/user.component';
import { HomeComponent } from './main/components/home/home.component';
import { TeachercheckinComponent } from './main/components/teachercheckin/teachercheckin.component';
import {CheckinService} from "./main/services/checkin.service";
import { AddcheckinComponent } from './main/components/teachercheckin/addcheckin/addcheckin.component';
import { MossComponent } from './main/components/moss/moss.component';
import {MossService} from "./main/services/moss.service";
import { StudcheckinComponent } from './main/components/studcheckin/studcheckin.component';
import {OrarComponent} from "./main/components/orar/orar.component";
import {OrarService} from "./main/services/orar.service";
import {AddOrarComponent} from "./main/components/orar/add-orar/add-orar.component";

@NgModule({
  declarations: [
    LoginComponent,
    ResetpassComponent,
    RegisterComponent,
    ValidateComponent,
    AppComponent,
    SidebarComponent,
    Sidebar2Component,
    KeysPipe,
    ConfirmationComponent,
    UsersComponent,
    AddComponent,
    EditComponent,
    FindComponent,
    CoursesComponent,
    AddcourseComponent,
    EditcourseComponent,
    FindcourseComponent,
    CoursedetailComponent,
    TabsComponent,
    CourseprojectsComponent,
    StudhomeworkComponent,
    NewhomeworkComponent,
    TeacherhomeworkComponent,
    AddmarkComponent,
    NavbarComponent,
    UserComponent,
    HomeComponent,
    TeachercheckinComponent,
    AddcheckinComponent,
    MossComponent,
    StudcheckinComponent,
    OrarComponent,
    AddOrarComponent
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
    MembersService,
    TeachersService,
    CoursesService,
    HomeworksService,
    UploadService,
    UserService,
    CheckinService,
    MossService,
    OrarService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
