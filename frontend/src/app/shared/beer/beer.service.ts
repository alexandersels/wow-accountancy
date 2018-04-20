import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Beer} from '../models/beer.model';

@Injectable()
export class BeerService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Beer[]> {
    return this.http.get<Beer[]>('/api/good-beers');
  }
}
