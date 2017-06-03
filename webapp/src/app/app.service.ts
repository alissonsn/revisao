import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Http} from '@angular/http';

@Injectable()
export class AppService {

  path = 'app';

  constructor(private http: Http) {
  }

}
