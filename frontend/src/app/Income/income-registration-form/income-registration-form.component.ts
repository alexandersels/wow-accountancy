import { Component, OnInit } from '@angular/core';
import { Income } from '../../shared/models/income.model';
import { IncomeService } from '../../shared/services/income.service';
import { Realm } from '../../shared/models/realm.model';
import { RealmService } from '../../shared/services/realm.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { Team } from '../../shared/models/team.model';
import { TeamService } from '../../shared/services/team.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-income-registration-form',
  templateUrl: './income-registration-form.component.html',
  styleUrls: ['./income-registration-form.component.scss']
})
export class IncomeRegistrationFormComponent extends Unsubscribe implements OnInit {

  income: Income = {};
  realms: Realm[];
  teams: Team[];

  form: FormGroup;

  dungeonName = new FormControl('', Validators.required);
  teamName = new FormControl('', Validators.required);
  realmName = new FormControl('', Validators.required);
  priceName = new FormControl('', Validators.required);

  constructor(
    private incomeService: IncomeService,
    private realmService: RealmService,
    private teamService: TeamService,
    private fb: FormBuilder,
    private location: Location
  ) {

    super();
    this.form = this.fb.group(
      {
        'dungeonName': this.dungeonName,
        'teamName': this.teamName,
        'realmName': this.realmName,
        'priceName': this.priceName
      },
    );
  }

  ngOnInit() {
    this.fetchRealms();
    this.fetchTeams();
  }

  register() {
    this.incomeService.createIncome(this.income).subscribe();
    this.goBack();
  }

  fetchRealms() {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  fetchTeams() {
    this.teamService.getTeams().subscribe(teams => this.teams = teams);
  }

  goBack(): void {
    this.location.back();
  }


}
