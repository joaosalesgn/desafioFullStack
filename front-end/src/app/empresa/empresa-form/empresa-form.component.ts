import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { EmpresaService } from '../services/empresa.service';

@Component({
  selector: 'app-empresa-form',
  templateUrl: './empresa-form.component.html',
  styleUrls: ['./empresa-form.component.css']
})
export class EmpresaFormComponent implements OnInit{

  form = this.formBuilder.group({
    cnpj: [''],
    nomeFantasia: [''],
    cep: [''],
    logradouro: [''],
    numero: [''],
    complemento: [''],
    telefone: ['']
  });

  constructor(private formBuilder: NonNullableFormBuilder,
    private service: EmpresaService,
    private snackBar: MatSnackBar,
    private location: Location) {
  }

  ngOnInit(): void {

  }

  onSubmit() {
    this.service.save(this.form.value)
    .subscribe(result => this.onSuccess(), error => { this.onError(error);
     });
  }

  onCancel() {
    this.location.back()
  }

  private onSuccess() {
    this.snackBar.open('Empresa salva com sucesso!', '', {duration: 5000});
    this.onCancel();
  }

  private onError(error: any) {
    this.snackBar.open(error.message, '', {duration: 7000})
  }
}
