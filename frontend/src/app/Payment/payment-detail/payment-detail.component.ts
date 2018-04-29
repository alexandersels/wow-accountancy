import { Component, OnInit } from '@angular/core';
import { Payment } from '../../shared/models/payment.model';
import { PaymentService } from '../../shared/services/payment.service';
import { ActivatedRoute, Route } from '@angular/router';
import { Location } from '@angular/common';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-payment-detail',
  templateUrl: './payment-detail.component.html',
  styleUrls: ['./payment-detail.component.scss']
})
export class PaymentDetailComponent extends Unsubscribe implements OnInit {

  payment: Payment;

  constructor(private paymentService: PaymentService,
              private route: ActivatedRoute,
              private location: Location)
  {
    super();
  }

  ngOnInit() {
    this.getPayment();
  }

  getPayment() : void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.paymentService.getPayment(id)
      .subscribe(payment => this.payment = payment);
  }

}
