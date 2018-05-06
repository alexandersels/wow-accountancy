import { Pipe } from '@angular/core';
import { Sort } from './sort';
import { Team } from '../../shared/models/team.model';


@Pipe({
  name: 'teamSort',
  pure: true
})

export class TeamSort extends Sort {

  transform(teams: Team[], sortType: string, reverse: boolean): Team[] {

    if(!sortType) return teams;
    if(!teams) return teams;

    return teams.sort((n1, n2) => this.compare(n1, n2, sortType, reverse))
  }

  compare(n1: Team, n2: Team, sortType: string, reverse: boolean): number {

    switch (sortType) {
      case 'name':
        return this.compareValues(n1.name, n2.name, reverse);
      case 'memberOne':
        return this.compareValues(n1.memberOne, n2.memberOne, reverse);
      case 'memberTwo':
        return this.compareValues(n1.memberTwo, n2.memberTwo, reverse);
      case 'memberThree':
        return this.compareValues(n1.memberThree, n2.memberThree, reverse);
      case 'memberFour':
        return this.compareValues(n1.memberFour, n2.memberFour, reverse);
    }

  }
}
