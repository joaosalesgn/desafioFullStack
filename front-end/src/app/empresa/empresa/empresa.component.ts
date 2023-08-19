import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Empresa } from '../model/empresa';
import { EmpresaService } from './../services/empresa.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

  empresas$: Observable<Empresa[]>;
  // Colunas que serão mostradas na tabela
  displayedColumns = ['id', 'nomeFantasia', 'cnpj', 'logradouro', 'telefone', 'actions']

  constructor(
    private empresaService: EmpresaService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.empresas$ = this.empresaService.list().pipe(
      catchError(error => {
        this.onError('Erro ao carregar as Empresas.')
        // retornando um Observable vazio "of" para ter alguma lista generica e parar o erro na tela
        return of([])
      })
    );
  }

  onError(errorMessage: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMessage
    })
  }

  ngOnInit(): void {
  }

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route })
  }
}
