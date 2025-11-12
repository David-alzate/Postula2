import { Component, OnDestroy, OnInit, inject } from '@angular/core';
import { AuthGoogleService } from '../../services/auth-google.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {
  loading = false;
  private subscriptions: Subscription[] = [];

  private authService = inject(AuthGoogleService);
  private router = inject(Router);

  ngOnInit(): void {
    this.subscriptions.push(
      this.authService.isLoggedIn$.subscribe(isLoggedIn => {
        if (isLoggedIn) {
          this.loading = false;
          this.router.navigate(['/postulantes']);
        } else if (isLoggedIn === false) {
          this.loading = false;
        }
      })
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  signInWithGoogle(): void {
    this.loading = true;
    this.authService.login();
  }

  blockNav(event: Event): void {
    event.preventDefault();
  }
}
