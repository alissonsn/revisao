import {Component, OnDestroy, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';

// Observable class extensions
import 'rxjs/add/observable/of';

// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import {Aprovador} from '../_domain/aprovador';
import { Setor } from '../_domain/setor';
import { User } from '../_domain/user';
import {MyUtil} from '../_util/my.util';
import {AprovadorService} from './aprovador.service';

@Component({
  selector: 'app-aprovador',
  templateUrl: './aprovador.component.html',
  styleUrls: ['./aprovador.component.css']
})
export class AprovadorComponent implements OnInit, OnDestroy {

  aprovador: Aprovador;
  setor: Setor;
  user: User;

  private ngUnsubscribe: Subject<void>;

  constructor(private aprovadorService: AprovadorService
    , private router: Router) {
  }

  ngOnInit() {
    this.aprovador = new Aprovador();
    this.setor = new Setor();
    this.user = new User();
    this.ngUnsubscribe = new Subject<void>();
  }

  salvar() {
    this.aprovadorService
      .register(this.aprovador)
      .takeUntil(this.ngUnsubscribe)
      .subscribe(
        ignore => {
          MyUtil.success('Aprovador cadastrado com sucesso.');
          this.aprovador = new Aprovador();
          this.router.navigate(['/aprovador']);
        },
        e => MyUtil.error(e)
      );
  }

  cancelar() {
    MyUtil.confirm('Deseja realmente cancelar esta operação? Todos os dados serão perdidos.', this);
  }

  _yes() {
    this.router.navigate(['/dashboard']);
  }

  _no() {

  }

  ngOnDestroy(): void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

}
