import { AvailableGoldPerRealm } from './available-gold-per-realm';

export interface AvailableGold {

  totalGold: number;
  remaingGold: number;
  goldPerRealm: AvailableGoldPerRealm[];

}
