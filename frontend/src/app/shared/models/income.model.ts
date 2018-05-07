import { Realm } from './realm.model';
import { Team } from './team.model';

export class Income {

  public dungeon: string;
  public price: number;
  public realm: Realm;
  public id: number;
  public team: Team;
  public date: Date;

  constructor() {

  }
}
