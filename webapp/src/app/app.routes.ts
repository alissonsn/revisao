import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './_guard/auth.guard';
import {TemplateComponent} from './template/template.component';
import {LoginComponent} from './login/login.component';
import {UsuariosComponent} from './usuarios/usuarios.component';

import {RegisterComponent} from './register/register.component';
import {RevisaoComponent} from './revisao/revisao.component';
import {DashboardComponent} from './dashboard/dashboard.component';

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
        component: DashboardComponent,
        path: 'dashboard'
      }
    ]
  },
  // not logged routes
  {
    component: LoginComponent,
    path: 'login'
  },
  {
    component: RegisterComponent,
    path: 'register'
  }
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
