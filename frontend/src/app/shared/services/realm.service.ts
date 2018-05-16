import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Realm } from '../models/realm.model';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RealmService {

  constructor(private http: HttpClient) {

  }

  createRealm(realm : Realm) : Observable<Realm> {
    return this.http.put<Realm>('/api/realm/', realm);
  }

  getRealms() : Observable<Realm[]> {
    return this.http.get<Realm[]>('/api/realm/');
  }

  getRealm(name: string) : Observable<Realm> {
    return this.http.get<Realm>('/api/realm/' + name);
  }

  updateRealm(realm: Realm) : Observable<Realm> {
    return this.http.post<Realm>('/api/realm/', realm);
  }
}
