import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './modules/Login/components/login/login.component';
import { AuthGuard } from './core/guards/auth.guard';
import { RegisterPostulantComponent } from './modules/Postulant/components/register-postulant/register-postulant.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'postulantes/registrar', component: RegisterPostulantComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: 'login' },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
