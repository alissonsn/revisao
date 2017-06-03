import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {Router} from '@angular/router';

import {Setor} from '../_domain/setor';
import {MyUtil} from '../_util/my.util';
import {SetorService} from './setor.service';

@Component({
  selector: 'app-setor',
  templateUrl: './setor.component.html',
  styleUrls: ['./setor.component.css']
})
export class SetorComponent implements OnInit, OnDestroy {

  setor: Setor;
  private ngUnsubscribe: Subject<void>;

  constructor(private setorService: SetorService
    , private router: Router) {
  }

  ngOnInit() {
    this.setor = new Setor();
    this.ngUnsubscribe = new Subject<void>();
  }

  salvar() {
    this.setorService
      .register(this.setor)
      .takeUntil(this.ngUnsubscribe)
      .subscribe(
        ignore => {
          MyUtil.success('Setor cadastrado com sucesso.');
          this.setor = new Setor();
          this.router.navigate(['/setor']);
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
