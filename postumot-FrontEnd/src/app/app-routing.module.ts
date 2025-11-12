import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './modules/Login/components/login/login.component';
import { AuthGuard } from './core/guards/auth.guard';
import { PostulantDashboardComponent } from './modules/Postulant/components/postulant-dashboard/postulant-dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'postulantes', component: PostulantDashboardComponent, canActivate: [AuthGuard] },
  { path: 'postulantes/registrar', redirectTo: 'postulantes', pathMatch: 'full' },
  { path: '**', redirectTo: 'login' },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
