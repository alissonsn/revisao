import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Http} from '@angular/http';

import {MyUtil} from '../_util/my.util';
import {Revisao} from '../_domain/revisao';

@Injectable()
export class RevisaoService {

  path = 'revisao';

  constructor(private http: Http) {
  }

  register(revisao: Revisao): Observable<any> {
    return this.http.post(MyUtil.url(this.path), JSON.stringify(revisao))
      .map(MyUtil.extrairDados)
      .catch(MyUtil.handleError);
  }


}
