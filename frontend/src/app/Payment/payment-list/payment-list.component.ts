import { Component, OnInit } from '@angular/core';
import { Payment } from '../../shared/models/payment.model';
import { PaymentService } from '../../shared/services/payment.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { ListComponentBase } from '../../shared/parents/listComponentBase';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.scss']
})
export class PaymentListComponent extends ListComponentBase {

  payments: Payment[];

  constructor(private paymentService: PaymentService)
  {
    super("name");
  }

  ngOnInit() {
    this.getPayments();
  }

  getPayments() : void {
    this.paymentService.getPayments()
      .subscribe(payments => this.payments = payments);
  }

}
