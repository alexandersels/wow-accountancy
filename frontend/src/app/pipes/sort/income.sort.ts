import { Pipe } from '@angular/core';
import { Sort } from './sort';
import { Income } from '../../shared/models/income.model';


@Pipe({
  name: 'incomeSort',
  pure: true
})
export class IncomeSort extends Sort {

  transform(incomes: Income[], sortType: string, reverse: boolean): Income[] {

    if(!sortType) return incomes;
    if(!incomes) return incomes;

    return incomes.sort((n1, n2) => this.compare(n1, n2, sortType, reverse))
  }

  compare(n1: Income, n2: Income, sortType: string, reverse: boolean): number {
    switch (sortType) {
      case 'team':
        return this.compareValues(n1.team, n2.team, reverse);
      case 'realm':
        return this.compareValues(n1.realm, n2.realm, reverse)
      case 'price':
        return this.compareValues(n1.price, n2.price, reverse)
      case 'date':
        return this.compareValues(n1.date, n2.date, reverse)
      case 'dungeon':
        return this.compareValues(n1.dungeon, n2.dungeon, reverse);
    }

  }
}
