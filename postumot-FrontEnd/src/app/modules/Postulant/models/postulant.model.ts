export interface PostulantDocumentType {
  id: string;
  nombre: string;
}

export interface Postulant {
  id: string;
  document: number;
  firstName: string;
  secondName?: string;
  lastName: string;
  lastSecondName?: string;
  phone: number;
  email: string;
  documentType: PostulantDocumentType;
}

export interface PostulantResponse {
  data: Postulant[];
  messages: string[];
}
