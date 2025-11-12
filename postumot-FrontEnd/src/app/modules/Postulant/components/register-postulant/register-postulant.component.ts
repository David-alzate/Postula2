import { Component, OnInit, Optional } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialogRef } from '@angular/material/dialog';
import { IdentificationType } from '../../models/identification-type.model';
import { IdentificationTypesService } from '../../services/identification-types.service';
import { PostulantService } from '../../services/postulant.service';

@Component({
  selector: 'app-register-postulant',
  templateUrl: './register-postulant.component.html',
  styleUrls: ['./register-postulant.component.css']
})
export class RegisterPostulantComponent implements OnInit {
  postulantForm: FormGroup;
  identificationTypes: IdentificationType[] = [];
  isSubmitting = false;
  isLoadingTypes = false;
  isDialogInstance = false;

  constructor(
    private fb: FormBuilder,
    private postulantService: PostulantService,
    private identificationTypesService: IdentificationTypesService,
    private snackBar: MatSnackBar,
    @Optional() private dialogRef?: MatDialogRef<RegisterPostulantComponent>
  ) {
    this.isDialogInstance = !!this.dialogRef;
    this.postulantForm = this.fb.group({
      documentTypeId: ['', Validators.required],
      document: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
      firstName: ['', Validators.required],
      secondName: [''],
      lastName: ['', Validators.required],
      lastSecondName: [''],
      phone: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
      email: ['', [Validators.required, Validators.email]],
    });
  }

  ngOnInit(): void {
    this.loadIdentificationTypes();
  }

  getControl(controlName: string) {
    return this.postulantForm.get(controlName);
  }

  private loadIdentificationTypes(): void {
    this.isLoadingTypes = true;
    this.identificationTypesService.getAll().subscribe({
      next: types => {
        this.identificationTypes = types;
        this.isLoadingTypes = false;
      },
      error: () => {
        this.isLoadingTypes = false;
        this.snackBar.open('No se pudieron cargar los tipos de identificacion.', 'Cerrar', {
          duration: 5000,
        });
      },
    });
  }

  submit(): void {
    if (this.postulantForm.invalid) {
      this.postulantForm.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;
    const value = this.postulantForm.value;

    this.postulantService
      .register({
        documentTypeId: value.documentTypeId,
        document: Number(value.document),
        firstName: value.firstName.trim(),
        secondName: value.secondName?.trim() ?? '',
        lastName: value.lastName.trim(),
        lastSecondName: value.lastSecondName?.trim() ?? '',
        phone: Number(value.phone),
        email: value.email.trim(),
      })
      .subscribe({
        next: () => {
          this.isSubmitting = false;
          this.snackBar.open('Postulante registrado exitosamente.', 'Cerrar', {
            duration: 4000,
          });
          this.postulantForm.reset();
          this.postulantForm.markAsPristine();
          this.postulantForm.markAsUntouched();
          this.closeDialog(true);
        },
        error: error => {
          this.isSubmitting = false;
          const message = error?.error?.messages?.[0] ?? 'No se pudo registrar el postulante.';
          this.snackBar.open(message, 'Cerrar', {
            duration: 5000,
          });
        },
      });
  }

  closeDialog(shouldReload = false): void {
    if (this.dialogRef) {
      this.dialogRef.close(shouldReload);
    }
  }
}
