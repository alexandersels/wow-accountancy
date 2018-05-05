import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../shared/models/realm.model';
import { Player } from '../shared/models/player.model';
import { Income } from '../shared/models/income.model';


@Pipe({
  name: 'incomesFilter',
  pure: false
})
export class IncomesSearchFilter implements PipeTransform {

  transform(incomes: Income[], searchText: string): Income[] {

    if (!incomes) return incomes;
    if (!searchText) return incomes;

    searchText = searchText.toLocaleLowerCase();

    return incomes.filter(income => {
      return income.team.toLowerCase().includes(searchText)
    });
  }
}
