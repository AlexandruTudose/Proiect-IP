var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component, ViewChild, Output, EventEmitter } from '@angular/core';
import { ModalComponent } from 'ng2-bs3-modal/components/modal';
import { MembersService } from '../../../services/members.service';
import { UserLog } from '../../../interfaces/UserLog';
import { Router } from '@angular/router';
export var LoginComponent = (function () {
    function LoginComponent(memberService, router) {
        this.memberService = memberService;
        this.router = router;
        this.errorlength = false;
        this.loginUrl = 'http://localhost:5991/login';
        this.pageChanged = new EventEmitter();
        this.userLog = new UserLog();
        this.memberService = memberService;
        this.router = router;
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent.prototype.loginUser = function () {
        this.login();
    };
    LoginComponent.prototype.login = function () {
        var _this = this;
        this.memberService.loginUsr(this.loginUrl, this.userLog.email, this.userLog.password).subscribe(function (succes) {
            _this.pageChanged.emit(true);
            _this.router.navigate(('/register'));
        }, function (error) {
            _this.err = true;
        }, function () {
        });
    };
    __decorate([
        ViewChild(ModalComponent), 
        __metadata('design:type', Object)
    ], LoginComponent.prototype, "errorlength", void 0);
    __decorate([
        Output(), 
        __metadata('design:type', Object)
    ], LoginComponent.prototype, "pageChanged", void 0);
    LoginComponent = __decorate([
        Component({
            selector: 'lp-login',
            templateUrl: './login.component.html',
            styleUrls: ['./login.component.css']
        }), 
        __metadata('design:paramtypes', [MembersService, Router])
    ], LoginComponent);
    return LoginComponent;
}());
//# sourceMappingURL=C:/Users/Andra/Desktop/Git/Proiect-IP/FontENdLoginRegister/src/app/main/components/user/login/login.component.js.map