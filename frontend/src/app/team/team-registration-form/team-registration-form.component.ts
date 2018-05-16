import { Component, OnInit } from '@angular/core';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { TeamService } from '../../shared/services/team.service';
import { Team } from '../../shared/models/team.model';
import { PlayerService } from '../../shared/services/player.service';
import { Player } from '../../shared/models/player.model';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-team-registration-form',
  templateUrl: './team-registration-form.component.html',
  styleUrls: ['./team-registration-form.component.scss']
})
export class TeamRegistrationFormComponent extends Unsubscribe implements OnInit {

  team: Team = {};
  players: Player[];

  form: FormGroup;

  teamName = new FormControl('', Validators.required);
  playerOne = new FormControl('', Validators.required);
  playerTwo = new FormControl('', Validators.required);
  playerThree = new FormControl('', Validators.required);
  playerFour = new FormControl('', Validators.required);

  constructor(private teamService: TeamService,
              private playerService: PlayerService,
              private fb: FormBuilder,
              private location: Location)
  {
    super();

    this.form = fb.group(
      {
        "teamName" : this.teamName,
        "playerOne" : this.playerOne,
        "playerTwo" : this.playerTwo,
        "playerThree" : this.playerThree,
        "playerFour" : this.playerFour,
      }
    );
  }

  ngOnInit() {
    this.fetchPlayers();
  }

  fetchPlayers() {
    this.playerService.getPlayers().subscribe(players => this.players = players);
  }
  register() {
    this.teamService.createTeam(this.team).subscribe();
    this.goBack();
  }

  goBack(): void {
    this.location.back();
  }

}
