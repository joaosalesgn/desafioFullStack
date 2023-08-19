import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmpresaComponent } from './empresa/empresa.component';
import { EmpresaFormComponent } from './empresa-form/empresa-form.component';

const routes: Routes = [
  { path: '', component: EmpresaComponent },
  { path: 'new', component: EmpresaFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpresaRoutingModule { }
