import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Income } from '../models/income.model';

@Injectable()
export class IncomeService {

  constructor(private http: HttpClient) {

  }

  createIncome(income: Income) : Observable<Income> {
    return this.http.put<Income>('/api/income/', income);
  }

  getIncomes(): Observable<Income[]> {
    return this.http.get<Income[]>('/api/income/');
  }

  getIncome(id: number): Observable<Income> {
    return this.http.get<Income>('/api/income/' + id);
  }
}
