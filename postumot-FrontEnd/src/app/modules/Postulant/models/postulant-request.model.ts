export interface RegisterPostulantRequest {
  document: number;
  firstName: string;
  secondName?: string;
  lastName: string;
  lastSecondName?: string;
  phone: number;
  email: string;
  documentTypeId: string;
}
