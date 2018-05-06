import { Pipe } from '@angular/core';
import { Sort } from './sort';
import { Player } from '../../shared/models/player.model';


@Pipe({
  name: 'playerSort',
  pure: true
})
export class PlayerSort extends Sort {

  transform(players: Player[], sortType: string, reverse: boolean): Player[] {

    if(!sortType) return players;
    if(!players) return players;

    return players.sort((n1, n2) => this.compare(n1, n2, sortType, reverse))
  }

  compare(n1: Player, n2: Player, sortType: string, reverse: boolean): number {

    switch (sortType) {
      case 'name':
        return this.compareValues(n1.name, n2.name, reverse);
    }

  }
}
