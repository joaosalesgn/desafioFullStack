import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { Empresa } from '../../model/empresa';

@Component({
  selector: 'app-empresa-list',
  templateUrl: './empresa-list.component.html',
  styleUrls: ['./empresa-list.component.css']
})
export class EmpresaListComponent implements OnInit {

  @Input() empresas: Empresa[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() delete = new EventEmitter(false);

  // Colunas que serão mostradas na tabela
  readonly displayedColumns = ['id', 'nomeFantasia', 'cnpj', 'logradouro', 'telefone', 'actions']

  constructor() {

  }

  ngOnInit(): void {
  }

  onAdd() {
    this.add.emit(true);
  }

  onEdit(empresa: Empresa) {
    this.edit.emit(empresa);
  }

  onDelete(empresa: Empresa) {
    this.delete.emit(empresa);
  }
}
