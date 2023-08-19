import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { EmpresaFormComponent } from './empresa-form/empresa-form.component';
import { EmpresaRoutingModule } from './empresa-routing.module';
import { EmpresaComponent } from './empresa/empresa.component';


@NgModule({
  declarations: [
    EmpresaComponent,
    EmpresaFormComponent
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
