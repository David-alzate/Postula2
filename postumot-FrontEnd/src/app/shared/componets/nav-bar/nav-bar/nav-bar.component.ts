import { Component, OnDestroy, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { AuthGoogleService } from 'src/app/modules/Login/services/auth-google.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit, OnDestroy {
  showNavbar: boolean = true;
  isLoggedIn: boolean = false;
  userProfile: any;
  private profileSubscription?: Subscription;
  private authSubscription?: Subscription;
  private routerSubscription?: Subscription;

  constructor(
    private router: Router,
    private authService: AuthGoogleService,
  ) {}

  ngOnInit(): void {
    this.showNavbar = this.router.url !== '/login';

    this.routerSubscription = this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.showNavbar = event.url !== '/login';
      }
    });

    this.profileSubscription = this.authService.profile$.subscribe(profile => {
      this.userProfile = profile;
    });

    this.authSubscription = this.authService.isLoggedIn$.subscribe(isLoggedIn => {
      this.isLoggedIn = !!isLoggedIn;
    });
  }

  ngOnDestroy(): void {
    this.profileSubscription?.unsubscribe();
    this.authSubscription?.unsubscribe();
    this.routerSubscription?.unsubscribe();
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
