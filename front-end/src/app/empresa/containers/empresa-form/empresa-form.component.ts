import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { EmpresaService } from '../../services/empresa.service';
import { Empresa } from '../../model/empresa';

@Component({
  selector: 'app-empresa-form',
  templateUrl: './empresa-form.component.html',
  styleUrls: ['./empresa-form.component.css']
})
export class EmpresaFormComponent implements OnInit{

  form = this.formBuilder.group({
    id: [Number('')],
    cnpj: ['', [Validators.required, Validators.minLength(14), Validators.maxLength(18)]],
    nomeFantasia: ['', Validators.required],
    cep: [''],
    logradouro: [''],
    numero: [''],
    complemento: [''],
    telefone: ['']
  });

  camposValidos: boolean = false;

  constructor(private formBuilder: NonNullableFormBuilder,
    private service: EmpresaService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const empresa: Empresa = this.route.snapshot.data['empresa'];
    this.form.setValue({
      id: Number(empresa.id),
      cnpj: empresa.cnpj,
      nomeFantasia: empresa.nomeFantasia,
      cep: empresa.cep,
      logradouro: empresa.logradouro,
      numero: empresa.numero,
      complemento: empresa.complemento,
      telefone: empresa.telefone
    });
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

  getMsgError(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
      return 'Campo obrigatório';
    }

    if (field?.hasError('maxlength')) {
      const requiredLength = field.errors ? field.errors['maxlength']['requiredLength'] : 18;
      return `Tamanho máximo precisa ser de ${requiredLength}`;
    }

    if (field?.hasError('minlength')) {
      const requiredLength = field.errors ? field.errors['minlength']['requiredLength'] : 14;
      return `Tamanho minimo precisa ser de ${requiredLength}`;
    }

    return '';
  }

  validaCampos(): boolean {
    this.camposValidos = this.getMsgError('cnpj') == '';

    if (this.camposValidos) this.camposValidos = this.getMsgError('nomeFantasia') == '';

    return this.camposValidos;
  }

  maskCnpj() {
    const field = this.form.get('cnpj');
    if (field !== null )
      this.form.get('cnpj')?.setValue(field.value.replace(/^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, "$1.$2.$3/$4-$5"));
  }
}
