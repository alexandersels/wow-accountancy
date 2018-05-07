import { Pipe, PipeTransform } from '@angular/core';
import { AvailableGoldPerRealm } from '../../shared/models/available-gold-per-realm';


@Pipe({
  name: 'goldPerServerFilter',
  pure: true
})
export class GoldPerServerSearchFilter implements PipeTransform {

  transform(goldPerServer: AvailableGoldPerRealm[], searchText: string): AvailableGoldPerRealm[] {

    if (!goldPerServer) return goldPerServer
    if (!searchText) return goldPerServer;

    searchText = searchText.toLocaleLowerCase();

    return goldPerServer.filter(gold => {
      return gold.realm.name.toLowerCase().includes(searchText)
    });
  }
}
