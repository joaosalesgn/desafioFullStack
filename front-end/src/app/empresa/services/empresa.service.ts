import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs/operators';

import { Empresa } from '../model/empresa';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  private readonly API = '/api/empresa'

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Empresa[]>(this.API).pipe(
      first(),
      // delay(5000)
    );
  }

  save(empresa: Partial<Empresa>) {
    if (empresa.id) {
      return this.update(empresa);
    }
    return this.create(empresa);
  }

  findById(id: string) {
    return this.httpClient.get<Empresa>(`${this.API}/${id}`);
  }

  private create(empresa: Partial<Empresa>) {
    return this.httpClient.post<Empresa>(this.API, empresa);
  }

  private update(empresa: Partial<Empresa>) {
    return this.httpClient.put<Empresa>(`${this.API}/${empresa.id}`, empresa);
  }

  public delete(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`);
  }
}
