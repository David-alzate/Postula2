import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { OAuthModule } from 'angular-oauth2-oidc'; // Importa el módulo

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './modules/Login/components/login/login.component';
import { NavBarComponent } from './shared/componets/nav-bar/nav-bar/nav-bar.component';
import { RegisterPostulantComponent } from './modules/Postulant/components/register-postulant/register-postulant.component';
import { PostulantDashboardComponent } from './modules/Postulant/components/postulant-dashboard/postulant-dashboard.component';
import { AuthTokenInterceptor } from './core/interceptors/auth-token.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavBarComponent,
    RegisterPostulantComponent,
    PostulantDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    BrowserAnimationsModule,
    OAuthModule.forRoot()
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthTokenInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA] // Agrega esto si es necesario
})
export class AppModule { }
