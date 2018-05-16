import { Realm } from './realm.model';
import { Team } from './team.model';

export interface Income {

  dungeon?: string;
  price?: number;
  realm?: Realm;
  id?: number;
  team?: Team;
  date?: Date;

}
