import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Http} from '@angular/http';

import {MyUtil} from '../_util/my.util';
import {Setor} from '../_domain/setor';

@Injectable()
export class SetorService {

  path = 'setor';

  constructor(private http: Http) {
  }

  register(setor: Setor): Observable<any> {
    return this.http.post(MyUtil.url(this.path), JSON.stringify(setor))
      .map(MyUtil.extrairDados)
      .catch(MyUtil.handleError);
  }


}
