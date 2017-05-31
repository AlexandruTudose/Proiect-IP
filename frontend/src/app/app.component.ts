import {Component, ElementRef} from '@angular/core';
import {User} from "./main/interfaces/User";
import {UserService} from "./main/services/user.service";

@Component({
  selector: 'ip-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  logged = false;
  userId: any;
  user: User = new User();
  register = false;
  validate = false;
  confirmation = false;

  constructor(private userService: UserService) {}

  ngOnInit() {
  }

  loggedIn(confirm) {
    this.logged = confirm;
  }

  usergetData(userid) {
    this.userId = userid;
    this.getUser(this.userId);
  }

  getUser(userId) {
    this.userService.getMember(userId).subscribe(
      (response) => {
        this.user = response;
        sessionStorage.setItem("firstName",this.user.firstName);
        sessionStorage.setItem("lastName",this.user.lastName);
        sessionStorage.setItem("role",this.user.role);
        sessionStorage.setItem("userId",this.user.id);
      }
    )
  }

  registerClick(confirmation) {
    this.register = confirmation;
    this.validate = false;
  }

  loginClick(confirmation) {
    this.register = confirmation;
    this.validate = false;
  }

  checkRegister(confirmation) {
    this.validate = confirmation;
  }

  logOut(confirmation) {
    if(confirmation) {
      this.logged = false;
      this.register = false;
      this.validate = false;
      sessionStorage.removeItem("firstName");
      sessionStorage.removeItem("lastName");
      sessionStorage.removeItem("role");
      sessionStorage.removeItem("userId");
    }
  }

}
