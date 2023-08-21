import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { EmpresaFormComponent } from './containers/empresa-form/empresa-form.component';
import { EmpresaRoutingModule } from './empresa-routing.module';
import { EmpresaComponent } from './containers/empresa/empresa.component';
import { EmpresaListComponent } from './components/empresa-list/empresa-list.component';
import { ConfirmationDialogComponent } from '../shared/components/confirmation-dialog/confirmation-dialog.component';


@NgModule({
  declarations: [
    EmpresaComponent,
    EmpresaFormComponent,
    EmpresaListComponent,
    ConfirmationDialogComponent
  ],
  imports: [
    CommonModule,
    EmpresaRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class EmpresaModule { }
