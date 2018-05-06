import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../../shared/models/realm.model';


@Pipe({
  name: 'realmFilter',
  pure: true
})
export class RealmSearchFilter implements PipeTransform {

  transform(realms: Realm[], searchText: string): Realm[] {

    if (!realms) return realms;
    if (!searchText) return realms;

    searchText = searchText.toLocaleLowerCase();

    return realms.filter(realm => {
      return realm.name.toLowerCase().includes(searchText)
    });
  }
}
