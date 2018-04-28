import { Component, OnInit } from '@angular/core';
import { Income } from '../shared/models/income.model';
import { IncomeService } from '../services/income.service';
import { Realm } from '../shared/models/realm.model';
import { RealmService } from '../services/realm.service';

@Component({
  selector: 'app-income-registration-form',
  templateUrl: './income-registration-form.component.html',
  styleUrls: ['./income-registration-form.component.css']
})
export class IncomeRegistrationFormComponent implements OnInit{

  income = new Income();
  realms: Realm[];

  constructor(private incomeService: IncomeService, private realmService: RealmService) { }

  ngOnInit() {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  register() {
    this.incomeService.createIncome(this.income).subscribe();
  }

}
