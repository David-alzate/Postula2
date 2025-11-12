import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Postulant } from '../../models/postulant.model';
import { PostulantService } from '../../services/postulant.service';
import { RegisterPostulantComponent } from '../register-postulant/register-postulant.component';

@Component({
  selector: 'app-postulant-dashboard',
  templateUrl: './postulant-dashboard.component.html',
  styleUrls: ['./postulant-dashboard.component.css']
})
export class PostulantDashboardComponent implements OnInit {
  postulants: Postulant[] = [];
  loading = false;
  errorMessage = '';

  constructor(
    private postulantService: PostulantService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.loadPostulants();
  }

  loadPostulants(): void {
    this.loading = true;
    this.errorMessage = '';

    this.postulantService.getAll().subscribe({
      next: postulants => {
        this.postulants = postulants;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
        this.errorMessage = 'No pudimos obtener la lista de postulantes. Intenta nuevamente.';
      }
    });
  }

  openCreateModal(): void {
    const dialogRef = this.dialog.open(RegisterPostulantComponent, {
      width: '720px',
      maxWidth: '90vw',
      autoFocus: false,
      disableClose: true,
      panelClass: 'postulant-dialog'
    });

    dialogRef.afterClosed().subscribe(shouldReload => {
      if (shouldReload) {
        this.loadPostulants();
      }
    });
  }

  getFullName(postulant: Postulant): string {
    return [postulant.firstName, postulant.secondName, postulant.lastName, postulant.lastSecondName]
      .filter(Boolean)
      .map(value => value?.trim())
      .join(' ');
  }

  getInitials(postulant: Postulant): string {
    const names = this.getFullName(postulant).split(' ');
    const initials = names
      .filter(Boolean)
      .slice(0, 2)
      .map(name => name[0]?.toUpperCase() ?? '');
    return initials.join('') || 'P';
  }

  trackByPostulant(_: number, postulant: Postulant): string {
    return postulant.id;
  }
}
