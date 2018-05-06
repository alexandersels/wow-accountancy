import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../../shared/models/realm.model';
import { Sort } from './sort';


@Pipe({
  name: 'realmSort',
  pure: true
})
export class RealmSort extends Sort {

  transform(realms: Realm[], sortType: string, reverse:boolean): Realm[] {

    if(!sortType) return realms;
    if(!realms) return realms;

    return realms.sort((n1, n2) => this.compare(n1, n2, sortType,reverse))
  }

   compare(n1: Realm, n2: Realm, sortType: string, reverse: boolean) : number
   {

     switch (sortType) {
       case "name":
         return this.compareValues(n1.name, n2.name, reverse);
       case "region":
         return this.compareValues(n1.region, n2.region, reverse)
       case "player":
         return this.compareValues(n1.player, n2.player, reverse)
     }

  }
}
