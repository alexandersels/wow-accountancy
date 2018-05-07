import { Realm } from './realm.model';
import { Player } from './player.model';

export class Payment {

  id: number;
  price: number;
  player: Player;
  realm: Realm;

  constructor() {

  }

}
