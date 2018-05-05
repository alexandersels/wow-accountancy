import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../shared/models/realm.model';


@Pipe({
  name: 'realmSort',
  pure: false
})
export class RealmSort implements PipeTransform {

  transform(realms: Realm[], sortType: string, reverse:boolean): Realm[] {
    return realms.sort((n1, n2) => this.compareString(n1, n2, reverse))
  }

   compareString(n1: Realm, n2: Realm, reverse: boolean) : number {
    if(reverse) {
      return n1.name > n2.name ? -1:1;
    }
    else {
      return n1.name < n2.name ? -1:1;
    }
  }
}
