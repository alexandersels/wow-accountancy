import { Component, OnInit } from '@angular/core';
import { Team } from '../../shared/models/team.model';
import { TeamService } from '../../shared/services/team.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-team-detail',
  templateUrl: './team-detail.component.html',
  styleUrls: ['./team-detail.component.css']
})
export class TeamDetailComponent extends Unsubscribe implements OnInit {

  public team: Team;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private teamService: TeamService)
  {
    super();
  }

  ngOnInit() {
    this.fetchTeam();
  }

  private fetchTeam() {
    const name = this.route.snapshot.paramMap.get("id");
    this.teamService.getTeam(name).subscribe(team => this.team = team);
  }

}
