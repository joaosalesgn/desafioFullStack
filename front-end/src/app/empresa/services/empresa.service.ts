import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap, first, delay } from 'rxjs/operators';

import { Empresa } from '../model/empresa';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  private readonly API = '/assets/empresa.json'

  constructor(private httpClient: HttpClient) { }

  dados() {
    return this.httpClient.get<Empresa[]>(this.API).pipe(
      first(),
      tap(empresas => console.log(empresas))
    );
  }
}
