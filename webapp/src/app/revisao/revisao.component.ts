import {Component, OnDestroy, OnInit} from '@angular/core';
import {Revisao} from '../_domain/revisao';
import {Subject} from 'rxjs/Subject';
import {MyUtil} from '../_util/my.util';
import {RevisaoService} from './revisao.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-revisao',
  templateUrl: './revisao.component.html',
  styleUrls: ['./revisao.component.css']
})
export class RevisaoComponent implements OnInit, OnDestroy {
  revisao: Revisao;
  private ngUnsubscribe: Subject<void>;

  constructor(private revisaoService: RevisaoService
    , private router: Router) {
  }

  ngOnInit() {
    this.revisao = new Revisao();
    this.ngUnsubscribe = new Subject<void>();
  }

  salvar() {
    this.revisaoService
      .register(this.revisao)
      .takeUntil(this.ngUnsubscribe)
      .subscribe(
        ignore => {
          MyUtil.success('Revisão cadastrada Com Sucesso');
          this.revisao = new Revisao();
          this.router.navigate(['/revisao']);
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
