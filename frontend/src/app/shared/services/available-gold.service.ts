import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AvailableGold } from '../models/available-gold.model';

@Injectable()
export class AvailableGoldService {

  constructor(private http: HttpClient) {

  }

  getAvailableGold(): Observable<AvailableGold> {
    return this.http.get<AvailableGold>("/api/availableGold/")
  }
}
