import { Component, OnInit } from '@angular/core';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { TeamService } from '../../shared/services/team.service';
import { Team } from '../../shared/models/team.model';
import { PlayerService } from '../../shared/services/player.service';
import { Player } from '../../shared/models/player.model';

@Component({
  selector: 'app-team-registration-form',
  templateUrl: './team-registration-form.component.html',
  styleUrls: ['./team-registration-form.component.scss']
})
export class TeamRegistrationFormComponent extends Unsubscribe implements OnInit {

  public team = new Team();
  public players: Player[];

  constructor(private teamService: TeamService,
              private playerService: PlayerService)
  {
    super();
  }

  ngOnInit() {
    this.fetchPlayers();
  }

  fetchPlayers() {
    this.playerService.getPlayers().subscribe(players => this.players = players);
  }
  register() {
    this.teamService.createTeam(this.team).subscribe()
  }

}
