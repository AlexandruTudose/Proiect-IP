import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SidebarComponent } from './common/components/sidebar/sidebar.component';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import {MembersService} from "./main/services/members.service";
import { KeysPipe } from './main/pipes/keys.pipe';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';
import { ConfirmationComponent } from './common/components/form/confirmation/confirmation.component';
import { routing, appRoutingProviders } from './config/routes';
import { StudentsComponent } from './main/components/students/students.component';
import { AddComponent } from './main/components/students/add/add.component';
import { EditComponent } from './main/components/students/edit/edit.component';
import { FindComponent } from './main/components/students/find/find.component';
import { TeachersComponent } from './main/components/teachers/teachers.component';
import { AddteacherComponent } from './main/components/teachers/addteacher/addteacher.component';
import {TeachersService} from "./main/services/teachers.service";
import { EditteacherComponent } from './main/components/teachers/editteacher/editteacher.component';
import { FindteacherComponent } from './main/components/teachers/findteacher/findteacher.component';
import { CoursesComponent } from './main/components/courses/courses.component';
import {CoursesService} from "./main/services/courses.service";
import { AddcourseComponent } from './main/components/courses/addcourse/addcourse.component';
import { EditcourseComponent } from './main/components/courses/editcourse/editcourse.component';
import { FindcourseComponent } from './main/components/courses/findcourse/findcourse.component';
import { CoursedetailComponent } from './main/components/courses/coursedetail/coursedetail.component';
import { TabsComponent } from './common/components/tabs/tabs.component';
import { CourseprojectsComponent } from './main/components/courses/coursedetail/courseprojects/courseprojects.component';
import { CoursegradesComponent } from './main/components/courses/coursedetail/coursegrades/coursegrades.component';
import { StudhomeworkComponent } from './main/components/studhomework/studhomework.component';
import {HomeworksService} from "./main/services/homeworks.service";
import {UploadService} from "./main/services/UploadService";
import { NewhomeworkComponent } from './main/components/studhomework/newhomework/newhomework.component';
import { TeacherhomeworkComponent } from './main/components/teacherhomework/teacherhomework.component';
import { AddmarkComponent } from './main/components/teacherhomework/addmark/addmark.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    KeysPipe,
    ConfirmationComponent,
    StudentsComponent,
    StudentsComponent,
    AddComponent,
    EditComponent,
    FindComponent,
    TeachersComponent,
    AddteacherComponent,
    EditteacherComponent,
    FindteacherComponent,
    CoursesComponent,
    AddcourseComponent,
    EditcourseComponent,
    FindcourseComponent,
    CoursedetailComponent,
    TabsComponent,
    CourseprojectsComponent,
    CoursegradesComponent,
    StudhomeworkComponent,
    NewhomeworkComponent,
    TeacherhomeworkComponent,
    AddmarkComponent

  ],
  imports: [
    Ng2Bs3ModalModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    ChartsModule,
    routing
  ],
  providers: [
    MembersService,
    TeachersService,
    CoursesService,
    HomeworksService,
    UploadService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
