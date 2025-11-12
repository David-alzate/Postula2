import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { IdentificationType } from '../models/identification-type.model';

@Injectable({ providedIn: 'root' })
export class IdentificationTypesService {
  private readonly API_URL = 'http://localhost:8080/api/v1/document-types';

  constructor(private http: HttpClient) {}

  getAll(): Observable<IdentificationType[]> {
    return this.http
      .get<{ data?: IdentificationType[] }>(this.API_URL)
      .pipe(map(response => response?.data ?? []));
  }
}
