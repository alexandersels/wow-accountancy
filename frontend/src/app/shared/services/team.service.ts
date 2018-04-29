import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Team } from '../models/team.model';

@Injectable()
export class TeamService {

  constructor(private http: HttpClient) {}

  createTeam(team: Team): Observable<Team> {
    return this.http.put<Team>('/api/team/', team);
  }

  getTeams(): Observable<Team[]> {
    return this.http.get<Team[]>('/api/team/');
  }

  getTeam(name: string): Observable<Team> {
    return this.http.get<Team>('/api/team/' + name);
  }

}
