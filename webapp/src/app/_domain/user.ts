import { Aprovador } from './aprovador';

export class User {

  constructor(public aprovadorSetores?: Aprovador[],
              public id?: number,
              public email?: string,
              public username?: string,
              public password?: string,
              public urlPerfil?: string) {
  }
}
