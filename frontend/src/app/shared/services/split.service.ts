import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Split } from '../models/split.model';

@Injectable()
export class SplitService {

  constructor(private http: HttpClient) {}

  getSplits(): Observable<Split[]> {
    return this.http.get<Split[]>("api/split/");
  }

  getSplit(name: string): Observable<Split> {
    return this.http.get<Split>("api/split/" + name);
  }

}
