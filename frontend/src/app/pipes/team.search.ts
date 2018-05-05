import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../shared/models/realm.model';
import { Player } from '../shared/models/player.model';
import { Team } from '../shared/models/team.model';


@Pipe({
  name: 'teamFilter',
  pure: false
})
export class TeamSearchFilter implements PipeTransform {

  transform(teams: Team[], searchText: string): Team[] {

    if (!teams) return teams;
    if (!searchText) return teams;

    searchText = searchText.toLocaleLowerCase();

    return teams.filter(team => {
      return team.name.toLowerCase().includes(searchText)
    });
  }
}
