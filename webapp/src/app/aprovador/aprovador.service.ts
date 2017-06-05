import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Http} from '@angular/http';

import {MyUtil} from '../_util/my.util';
import {Aprovador} from '../_domain/aprovador';

@Injectable()
export class AprovadorService {

  private path = 'aprovador';

  constructor(private http: Http) {
  }

  register(setor: Aprovador): Observable<any> {
    return this.http.post(MyUtil.url(this.path), JSON.stringify(setor))
      .map(MyUtil.extrairDados)
      .catch(MyUtil.handleError);
  }

  getList(): Observable<Aprovador[]> {
    return this.http.get(MyUtil.url(this.path+'/listar'))
      .map(MyUtil.extrairDados)
      .catch(MyUtil.handleError);
  }


}
