import {Aprovador} from './aprovador';

export class Setor {

  constructor(public aprovadorSetores?: Aprovador[],
              public id?: number,
              public nome?: string) {
  }
}
