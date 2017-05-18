var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { SidebarComponent } from './common/components/sidebar/sidebar.component';
import { MembersService } from './main/services/members.service';
import { KeysPipe } from './main/pipes/keys.pipe';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';
import { routing } from './config/routes';
import { LoginComponent } from './main/components/user/login/login.component';
import { RegisterComponent } from './main/components/user/register/register.component';
import { ValidateComponent } from './main/components/user/validate/validate.component';
import { ResetpassComponent } from './main/components/user/resetpass/resetpass.component';
export var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        NgModule({
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
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
//# sourceMappingURL=C:/Users/Andra/Desktop/Git/Proiect-IP/FontENdLoginRegister/src/app/app.module.js.map