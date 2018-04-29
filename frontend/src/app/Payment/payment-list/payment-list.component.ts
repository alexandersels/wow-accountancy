import { Component, OnInit } from '@angular/core';
import { Payment } from '../../shared/models/payment.model';
import { PaymentService } from '../../shared/services/payment.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent extends Unsubscribe implements OnInit {

  payments: Payment[];

  constructor(private paymentService: PaymentService)
  {
    super();
  }

  ngOnInit() {
    this.getPayments();
  }

  getPayments() : void {
    this.paymentService.getPayments()
      .subscribe(payments => this.payments = payments);
  }

}
