import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../../shared/models/realm.model';
import { Player } from '../../shared/models/player.model';
import { Income } from '../../shared/models/income.model';
import { AvailableGoldPerRealm } from '../../shared/models/available-gold-per-realm';
import { Split } from '../../shared/models/split.model';


@Pipe({
  name: 'splitFilter',
  pure: true
})
export class SplitSearchFilter implements PipeTransform {

  transform(splits: Split[], searchText: string): Split[] {

    if (!splits) return splits;
    if (!searchText) return splits;

    searchText = searchText.toLocaleLowerCase();

    return splits.filter(split => {
      return split.playerName.toLowerCase().includes(searchText)
    });
  }
}
