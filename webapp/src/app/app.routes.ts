import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './_guard/auth.guard';
import {TemplateComponent} from './template/template.component';
import {LoginComponent} from './login/login.component';
import {UsuariosComponent} from './usuarios/usuarios.component';

import {RegisterComponent} from './register/register.component';
import {RevisaoComponent} from './revisao/revisao.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {SetorComponent} from './setor/setor.component';
import {SetorlistComponent} from './setorlist/setorlist.component';
import {AprovadorComponent} from './aprovador/aprovador.component';
import {AprovadorlistComponent} from './aprovadorlist/aprovadorlist.component';
import { RevisaolistComponent } from './revisaolist/revisaolist.component';

const routes: Routes = [
  // logged routes
  {
    canActivate: [AuthGuard],
    component: TemplateComponent,
    path: '',
    children: [
      {
        canActivate: [AuthGuard],
        component: RevisaoComponent,
        path: 'revisao'
      },
      {
        canActivate: [AuthGuard],
        component: RevisaolistComponent,
        path: 'revisaolist'
      },
      {
        canActivate: [AuthGuard],
        component: UsuariosComponent,
        path: 'users'
      },
      {
        canActivate: [AuthGuard],
        component: SetorComponent,
        path: 'setor'
      },
      {
        canActivate: [AuthGuard],
        component: SetorlistComponent,
        path: 'setorlist'
      },
      {
        canActivate: [AuthGuard],
        component: AprovadorComponent,
        path: 'aprovador'
      },
      {
        canActivate: [AuthGuard],
        component: AprovadorlistComponent,
        path: 'aprovadorlist'
      },
      {
        canActivate: [AuthGuard],
        component: DashboardComponent,
        path: 'dashboard'
      },
      {
        canActivate: [AuthGuard],
        component: RegisterComponent,
        path: 'register'
      }
    ]
  },
  // not logged routes
  {
    component: LoginComponent,
    path: 'login'
  }
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
