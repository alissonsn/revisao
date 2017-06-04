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
