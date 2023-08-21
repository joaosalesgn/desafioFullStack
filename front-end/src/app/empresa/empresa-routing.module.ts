import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmpresaComponent } from './containers/empresa/empresa.component';
import { EmpresaFormComponent } from './containers/empresa-form/empresa-form.component';
import { EmpresaResolver } from './guards/empresa.resolver';

const routes: Routes = [
  { path: '', component: EmpresaComponent },
  { path: 'new', component: EmpresaFormComponent, resolve: { empresa: EmpresaResolver } },
  { path: 'edit/:id', component: EmpresaFormComponent, resolve: { empresa: EmpresaResolver } }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpresaRoutingModule { }
