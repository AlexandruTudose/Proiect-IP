var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, URLSearchParams } from "@angular/http";
import 'rxjs/add/operator/map';
export var MembersService = (function () {
    function MembersService(http) {
        this.http = http;
        this.headers = new Headers({ 'Content-Type': 'application/json' });
        this.getStudents = "/api/students";
        this.http = http;
    }
    MembersService.prototype.getList = function () {
        return this.http.get(this.getStudents)
            .map(function (response) { return response.json(); });
    };
    MembersService.prototype.getListSimple = function (link) {
        return this.http.get(link)
            .map(function (response) { return response.json(); });
    };
    MembersService.prototype.getMember = function (link, id) {
        return this.http.get(link + id)
            .map(function (res) { return res.json(); });
    };
    MembersService.prototype.updateObject = function (link, postObject) {
        return this.http.post(link, JSON.stringify(postObject), new RequestOptions({ headers: this.headers }))
            .map(function (response) { return response; });
    };
    MembersService.prototype.loginUsr = function (link, email, password) {
        var headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        var urlSearchParams = new URLSearchParams();
        urlSearchParams.append('email', email);
        urlSearchParams.append('password', password);
        var body = urlSearchParams.toString();
        return this.http.post(link, body, new RequestOptions({ headers: headers }))
            .map(function (response) { return response; });
    };
    MembersService.prototype.validateEml = function (link, email, code) {
        var headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        var urlSearchParams = new URLSearchParams();
        urlSearchParams.append('email', email);
        urlSearchParams.append('code', code);
        var body = urlSearchParams.toString();
        return this.http.post(link, body, new RequestOptions({ headers: headers }))
            .map(function (response) { return response; });
    };
    MembersService.prototype.registerUsr = function (link, postObject) {
        return this.http.post(link, JSON.stringify(postObject), new RequestOptions({ headers: this.headers }))
            .map(function (response) { return response; });
    };
    MembersService.prototype.updateMember = function (link, id, putObject) {
        return this.http.put(link + id, JSON.stringify(putObject), new RequestOptions({ headers: this.headers }))
            .map(function (response) { return response; });
    };
    MembersService.prototype.deleteObject = function (link, id) {
        return this.http.delete(link + "/" + id).map(function (response) { return response; });
    };
    MembersService.prototype.loginService = function (url, username, password) {
        var headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        var urlSearchParams = new URLSearchParams();
        urlSearchParams.append('username', username);
        urlSearchParams.append('password', password);
        var body = urlSearchParams.toString();
        return this.http.post(url, body, new RequestOptions({ headers: headers }))
            .map(function (response) { return response; });
    };
    MembersService.prototype.setSearch = function (searchParamas) {
        this.search = new URLSearchParams();
        this.search.set("page", searchParamas.page.toString());
        this.search.set("size", searchParamas.size.toString());
        this.search.set("sort", searchParamas.sort.toString());
        for (var key in searchParamas.search) {
            if (searchParamas.search.hasOwnProperty(key)) {
                var val = searchParamas.search[key];
                this.search.set(key, val);
            }
        }
        console.log(this.search.toString());
    };
    MembersService = __decorate([
        Injectable(), 
        __metadata('design:paramtypes', [Http])
    ], MembersService);
    return MembersService;
}());
//# sourceMappingURL=C:/Users/Andra/Desktop/Git/Proiect-IP/FontENdLoginRegister/src/app/main/services/members.service.js.map