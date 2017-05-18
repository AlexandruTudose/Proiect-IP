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
import { ModalComponent } from "ng2-bs3-modal/components/modal";
import { MembersService } from "../../../services/members.service";
import { User } from "../../../interfaces/User";
export var RegisterComponent = (function () {
    function RegisterComponent(memberService) {
        this.memberService = memberService;
        this.user = new User();
        this.errorlength = false;
        this.registerUrl = "http://localhost:5991/register";
        this.pageChanged = new EventEmitter();
        this.memberService = memberService;
    }
    RegisterComponent.prototype.ngOnInit = function () {
    };
    RegisterComponent.prototype.registerUser = function () {
        this.register();
    };
    RegisterComponent.prototype.register = function () {
        var _this = this;
        this.memberService.registerUsr(this.registerUrl, this.user).subscribe(function (succes) {
            _this.pageChanged.emit(true);
        }, function (error) {
            _this.err = true;
        }, function () {
        });
    };
    __decorate([
        ViewChild(ModalComponent), 
        __metadata('design:type', ModalComponent)
    ], RegisterComponent.prototype, "modalMember", void 0);
    __decorate([
        Output(), 
        __metadata('design:type', Object)
    ], RegisterComponent.prototype, "pageChanged", void 0);
    RegisterComponent = __decorate([
        Component({
            selector: 'ip-register',
            templateUrl: './register.component.html',
            styleUrls: ['./register.component.css']
        }), 
        __metadata('design:paramtypes', [MembersService])
    ], RegisterComponent);
    return RegisterComponent;
}());
//# sourceMappingURL=C:/Users/Andra/Desktop/Git/Proiect-IP/FontENdLoginRegister/src/app/main/components/user/register/register.component.js.map