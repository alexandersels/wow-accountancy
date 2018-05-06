import { Component } from '@angular/core';
import { TeamService } from '../../shared/services/team.service';
import { Team } from '../../shared/models/team.model';
import { ListComponentBase } from '../../shared/parents/listComponentBase';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.scss']
})
export class TeamListComponent extends ListComponentBase {

  teams: Team[];
selectedTeam: Team;

  constructor(private teamService: TeamService) {
    super('name');
  }

  ngOnInit() {
    this.fetchTeams();
  }

  fetchTeams() {
    this.teamService.getTeams().subscribe(teams => this.teams = teams);
  }

  setSelectedTeam(selectedTeam: Team) {
    this.selectedTeam = selectedTeam;
  }

}
