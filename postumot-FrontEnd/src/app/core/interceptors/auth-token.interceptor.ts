import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { OAuthService } from 'angular-oauth2-oidc';

/**
 * Attaches the ID token to backend API calls so the API Gateway can authorize
 * requests. Remove or adjust this once security requirements change.
 */
@Injectable()
export class AuthTokenInterceptor implements HttpInterceptor {
  private readonly backendBaseUrl = 'http://localhost:8080';

  constructor(private oauthService: OAuthService) {}

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (!req.url.startsWith(this.backendBaseUrl)) {
      return next.handle(req);
    }

    const idToken = this.oauthService.getIdToken();
    if (!idToken) {
      return next.handle(req);
    }

    const authorizedRequest = req.clone({
      setHeaders: {
        Authorization: `Bearer ${idToken}`
      }
    });

    return next.handle(authorizedRequest);
  }
}
