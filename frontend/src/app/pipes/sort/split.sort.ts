import { Pipe } from '@angular/core';
import { Sort } from './sort';
import { AvailableGoldPerRealm } from '../../shared/models/available-gold-per-realm';
import { Split } from '../../shared/models/split.model';


@Pipe({
  name: 'splitSort',
  pure: true
})
export class SplitSort extends Sort {

  transform(splits: Split[], sortType: string, reverse: boolean): Split[] {

    if(!sortType) return splits;
    if(!splits) return splits;

    return splits.sort((n1, n2) => this.compare(n1, n2, sortType, reverse))
  }

  compare(n1: Split, n2: Split, sortType: string, reverse: boolean): number {
    switch (sortType) {
      case 'amountOfRuns':
        return this.compareValues(n1.amountOfRuns, n2.amountOfRuns, reverse)
      case 'debt':
        return this.compareValues(n1.debt, n2.debt, reverse)
      case 'player':
        return this.compareValues(n1.playerName, n2.playerName, reverse)
    }

  }
}
