import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../shared/models/realm.model';


@Pipe({
  name: 'realmSort',
  pure: false
})
export class RealmSort implements PipeTransform {

  transform(realms: Realm[], sortType: string, reverse:boolean): Realm[] {
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

  compareValues(valueOne: any, valueTwo: any, reverse: boolean) : number {
    if(reverse) {
      return valueOne > valueTwo ? -1:1;
    }
    else {
      return valueOne < valueTwo ? -1:1;
    }
  }
}
