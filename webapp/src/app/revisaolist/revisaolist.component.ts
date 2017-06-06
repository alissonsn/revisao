import { Component, OnInit } from '@angular/core';

import {Subject} from 'rxjs/Subject';

import {RevisaoService} from '../revisao/revisao.service';
import {Revisao} from '../_domain/revisao';
import {MyUtil} from '../_util/my.util';

@Component({
  selector: 'app-revisaolist',
  templateUrl: './revisaolist.component.html',
  styleUrls: ['./revisaolist.component.css']
})
export class RevisaolistComponent implements OnInit {

  list: Revisao[];
  private ngUnsubscribe: Subject<void>;

  constructor(private revisaoService: RevisaoService) {
  }

  ngOnInit() {
    this.list = [];
    this.ngUnsubscribe = new Subject<void>();
    this.revisaoService.getList()
      .takeUntil(this.ngUnsubscribe)
      .subscribe(
        obj => this.list = obj,
        e => MyUtil.error(e)
      );
  }

}
