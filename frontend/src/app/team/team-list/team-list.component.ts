import { Component, OnInit } from '@angular/core';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { TeamService } from '../../shared/services/team.service';
import { Team } from '../../shared/models/team.model';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.scss']
})
export class TeamListComponent extends Unsubscribe implements OnInit {

  public teams: Team[];

  constructor(private teamService: TeamService) {
    super();
  }

  ngOnInit() {
    this.fetchTeams();
  }

  fetchTeams() {
    this.teamService.getTeams().subscribe(teams => this.teams = teams);
  }

}
