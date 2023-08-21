import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Empresa } from '../../model/empresa';
import { EmpresaService } from '../../services/empresa.service';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

  empresas$: Observable<Empresa[]> | null = null;

  constructor(private empresaService: EmpresaService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar) {

    this.buscarDados();
  }

  ngOnInit(): void {}

  private buscarDados() {
    this.empresas$ = this.empresaService.list().pipe(
      catchError(error => {
        this.onError(error.message)
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

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route })
  }

  onEdit(empresa: Empresa) {
    this.router.navigate(['edit', empresa.id], { relativeTo: this.route })
  }

  onDelete(empresa: Empresa) {
    const nomeEmpresa = empresa.nomeFantasia;
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: `Tem certeza que deseja remover a empresa ${nomeEmpresa}?`
    });

    dialogRef.afterClosed().subscribe((result: Boolean) => {
      if (result) {
        this.empresaService.delete(String(empresa.id)).subscribe(
          () => {
            this.buscarDados();
            this.snackBar.open(`Empresa ${nomeEmpresa} removida com sucesso!`, 'X', {
              duration: 7000,
              verticalPosition: 'top',
              horizontalPosition: 'center'
            })
          },
          () => this.onError('Erro ao tentar deletar a empresa')
        );
      }
    })
  }
}
