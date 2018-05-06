import { Pipe } from '@angular/core';
import { Sort } from './sort';
import { AvailableGoldPerRealm } from '../../shared/models/available-gold-per-realm';


@Pipe({
  name: 'goldPerServerSort',
  pure: true
})
export class GoldPerServerSort extends Sort {

  transform(availableGold: AvailableGoldPerRealm[], sortType: string, reverse: boolean): AvailableGoldPerRealm[] {

    if(!sortType) return availableGold;
    if(!availableGold) return availableGold;

    return availableGold.sort((n1, n2) => this.compare(n1, n2, sortType, reverse))
  }

  compare(n1: AvailableGoldPerRealm, n2: AvailableGoldPerRealm, sortType: string, reverse: boolean): number {
    switch (sortType) {
      case 'realm':
        return this.compareValues(n1.realm, n2.realm, reverse)
      case 'gold':
        return this.compareValues(n1.gold, n2.gold, reverse)
      case 'player':
        return this.compareValues(n1.player, n2.player, reverse)
    }

  }
}
