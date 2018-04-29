import { Component, OnInit } from '@angular/core';
import { Income } from '../../shared/models/income.model';
import { IncomeService } from '../../shared/services/income.service';
import { Realm } from '../../shared/models/realm.model';
import { RealmService } from '../../shared/services/realm.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { Team } from '../../shared/models/team.model';
import { TeamService } from '../../shared/services/team.service';

@Component({
  selector: 'app-income-registration-form',
  templateUrl: './income-registration-form.component.html',
  styleUrls: ['./income-registration-form.component.scss']
})
export class IncomeRegistrationFormComponent extends Unsubscribe implements OnInit {

  public income = new Income();
  public realms: Realm[];
  public teams: Team[];

  constructor(
    private incomeService: IncomeService,
    private realmService: RealmService,
    private teamService: TeamService)
  {
    super();
  }

  public ngOnInit() {
    this.fetchRealms();
    this.fetchTeams();
  }

  public register() {
    this.incomeService.createIncome(this.income)
      .subscribe();
  }

  private fetchRealms() {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  private fetchTeams() {
    this.teamService.getTeams().subscribe(teams => this.teams = teams);
  }
}
