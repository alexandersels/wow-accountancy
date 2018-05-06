import { Pipe, PipeTransform } from '@angular/core';
import { Payment } from '../../shared/models/payment.model';


@Pipe({
  name: 'paymentFilter',
  pure: true
})
export class PaymentSearchFilter implements PipeTransform {

  transform(payments: Payment[], searchText: string): Payment[] {

    if (!payments) return payments;
    if (!searchText) return payments;

    searchText = searchText.toLocaleLowerCase();

    return payments.filter(payment => {
      return payment.player.toLowerCase().includes(searchText)
    });
  }
}
