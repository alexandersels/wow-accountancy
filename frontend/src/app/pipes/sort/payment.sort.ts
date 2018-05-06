import { Pipe, PipeTransform } from '@angular/core';
import { Realm } from '../../shared/models/realm.model';
import { Sort } from './sort';
import { Payment } from '../../shared/models/payment.model';


@Pipe({
  name: 'paymentSort',
  pure: true
})
export class PaymentSort extends Sort {

  transform(payments: Payment[], sortType: string, reverse:boolean): Payment[] {

    if(!sortType) return payments;
    if(!payments) return payments;

    return payments.sort((n1, n2) => this.compare(n1, n2, sortType,reverse))
  }

   compare(n1: Payment, n2: Payment, sortType: string, reverse: boolean) : number
   {
     switch (sortType) {
       case "player":
         return this.compareValues(n1.player, n2.player, reverse);
       case "realm":
         return this.compareValues(n1.realm, n2.realm, reverse)
       case "price":
         return this.compareValues(n1.price, n2.price, reverse)
     }

  }
}
