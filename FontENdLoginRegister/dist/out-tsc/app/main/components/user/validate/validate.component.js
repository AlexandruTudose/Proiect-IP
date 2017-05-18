var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component, Output, EventEmitter } from '@angular/core';
import { MembersService } from '../../../services/members.service';
export var ValidateComponent = (function () {
    function ValidateComponent(memberService) {
        this.memberService = memberService;
        this.errorlength = false;
        this.validateUrl = 'http://localhost:5991/register/validate';
        this.pageChanged = new EventEmitter();
        this.memberService = memberService;
    }
    ValidateComponent.prototype.ngOnInit = function () {
    };
    ValidateComponent.prototype.validateEmail = function () {
        this.validate();
    };
    ValidateComponent.prototype.validate = function () {
        var _this = this;
        this.memberService.validateEml(this.validateUrl, this.email, this.code).subscribe(function (succes) {
            _this.pageChanged.emit(true);
        }, function (error) {
            _this.err = true;
        }, function () {
        });
    };
    __decorate([
        Output(), 
        __metadata('design:type', Object)
    ], ValidateComponent.prototype, "pageChanged", void 0);
    ValidateComponent = __decorate([
        Component({
            selector: 'ip-validate',
            templateUrl: './validate.component.html',
            styleUrls: ['./validate.component.css']
        }), 
        __metadata('design:paramtypes', [MembersService])
    ], ValidateComponent);
    return ValidateComponent;
}());
//# sourceMappingURL=C:/Users/Andra/Desktop/Git/Proiect-IP/FontENdLoginRegister/src/app/main/components/user/validate/validate.component.js.map