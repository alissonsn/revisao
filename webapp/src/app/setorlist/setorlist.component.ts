import { Component, OnInit } from '@angular/core';
import {Subject} from 'rxjs/Subject';

import {SetorService} from '../setor/setor.service';
import {Setor} from '../_domain/setor';
import {MyUtil} from '../_util/my.util';

@Component({
  selector: 'app-setorlist',
  templateUrl: './setorlist.component.html',
  styleUrls: ['./setorlist.component.css']
})
export class SetorlistComponent implements OnInit {

  list: Setor[];
  private ngUnsubscribe: Subject<void>;

  constructor(private usuariosService: SetorService) {
  }

  ngOnInit() {
    this.list = [];
    this.ngUnsubscribe = new Subject<void>();
    this.usuariosService.getList()
      .takeUntil(this.ngUnsubscribe)
      .subscribe(
        obj => this.list = obj,
        e => MyUtil.error(e)
      );
  }

}
