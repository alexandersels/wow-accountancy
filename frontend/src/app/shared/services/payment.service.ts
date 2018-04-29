import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Payment } from '../models/payment.model';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PaymentService {

  constructor(private http: HttpClient) {

  }

  createPayment(payment: Payment): Observable<Payment> {
    return this.http.put<Payment>("/api/payment", payment);
  }

  getPayments():Observable<Payment[]> {
    return this.http.get<Payment[]>("api/payment");
  }

  getPayment(id: number): Observable<Payment> {
    return this.http.get<Payment>('/api/payment/' + id);
  }
}
