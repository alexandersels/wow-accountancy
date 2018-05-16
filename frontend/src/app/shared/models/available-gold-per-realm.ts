import { Realm } from './realm.model';
import { Player } from './player.model';

export interface AvailableGoldPerRealm {

  realm: Realm;
  gold: number;
  player: Player;

}
