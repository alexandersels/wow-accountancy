import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { DungeonsStatic } from '../models/statistics/dungeons.static';

@Injectable()
export class StatisticsService {

  constructor(private http: HttpClient) {

  }

  getDungeonStatistics(): Observable<DungeonsStatic> {
    return this.http.get<DungeonsStatic>("/api/dungeonStatistics");
  }
}
