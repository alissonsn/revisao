import {User} from './user';
import {Setor} from './setor';

export class Aprovador {

  constructor(public id?: number,
              public user?: User,
              public setor?: Setor) {
  }
}
