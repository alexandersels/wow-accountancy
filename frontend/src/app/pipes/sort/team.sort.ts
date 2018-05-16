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
        return this.compareValues(n1.memberOne.name, n2.memberOne.name, reverse);
      case 'memberTwo':
        return this.compareValues(n1.memberTwo.name, n2.memberTwo.name, reverse);
      case 'memberThree':
        return this.compareValues(n1.memberThree.name, n2.memberThree.name, reverse);
      case 'memberFour':
        return this.compareValues(n1.memberFour.name, n2.memberFour.name, reverse);
    }

  }
}
