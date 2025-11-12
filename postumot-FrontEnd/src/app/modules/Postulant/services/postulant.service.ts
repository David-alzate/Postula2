import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterPostulantRequest } from '../models/postulant-request.model';

@Injectable({ providedIn: 'root' })
export class PostulantService {
  private readonly API_URL = 'http://localhost:8080/api/v1/postulantes';

  constructor(private http: HttpClient) {}

  register(payload: RegisterPostulantRequest): Observable<any> {
    const body = {
      document: payload.document,
      firstName: payload.firstName,
      secondName: payload.secondName ?? '',
      lastName: payload.lastName,
      lastSecondName: payload.lastSecondName ?? '',
      phone: payload.phone,
      email: payload.email,
      documentType: {
        id: payload.documentTypeId,
      },
    };

    return this.http.post(this.API_URL, body);
  }
}
