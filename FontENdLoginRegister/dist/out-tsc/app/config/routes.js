import { RouterModule } from '@angular/router';
import { LoginComponent } from '../main/components/user/login/login.component';
import { RegisterComponent } from '../main/components/user/register/register.component';
import { ValidateComponent } from '../main/components/user/validate/validate.component';
import { ResetpassComponent } from '../main/components/user/resetpass/resetpass.component';
export var routes = [
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'login/reset', component: ResetpassComponent },
    { path: 'register/validate', component: ValidateComponent },
    { path: '', redirectTo: '/login', pathMatch: 'full' }
];
export var appRoutingProviders = [];
export var routing = RouterModule.forRoot(routes);
//# sourceMappingURL=C:/Users/Andra/Desktop/Git/Proiect-IP/FontENdLoginRegister/src/app/config/routes.js.map