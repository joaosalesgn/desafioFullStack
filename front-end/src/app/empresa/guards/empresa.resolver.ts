import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { Empresa } from '../model/empresa';
import { EmpresaService } from '../services/empresa.service';

@Injectable({
  providedIn: 'root'
})
export class EmpresaResolver implements Resolve<Empresa> {

  constructor(private service: EmpresaService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Empresa> {
    if (route.params && route.params['id']) {
      return this.service.findById(route.params['id']);
    }
    return of({ nomeFantasia: '', cnpj: '', cep: '', logradouro: '', numero: '', complemento: '', telefone: '' });
  }
}
