import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../../shared/models/realm.model';
import { Player } from '../../shared/models/player.model';


@Pipe({
  name: 'playerFilter',
  pure: true
})
export class PlayerSearchFilter implements PipeTransform {

  transform(players: Player[], searchText: string): Player[] {

    if (!players) return players;
    if (!searchText) return players;

    searchText = searchText.toLocaleLowerCase();

    return players.filter(player => {
      return player.name.toLowerCase().includes(searchText)
    });
  }
}
