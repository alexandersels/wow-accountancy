import { Component, OnInit } from '@angular/core';
import { Payment } from '../../shared/models/payment.model';
import { PaymentService } from '../../shared/services/payment.service';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent implements OnInit {

  payments: Payment[];

  constructor(private paymentService: PaymentService) { }

  ngOnInit() {
    this.getPayments();
  }

  getPayments() : void {
    this.paymentService.getPayments().subscribe(payments => this.payments = payments);
  }

}
