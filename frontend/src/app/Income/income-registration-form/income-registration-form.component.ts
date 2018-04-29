import { Component, OnInit } from '@angular/core';
import { Income } from '../../shared/models/income.model';
import { IncomeService } from '../../shared/services/income.service';
import { Realm } from '../../shared/models/realm.model';
import { RealmService } from '../../shared/services/realm.service';
import { Unsubscribable } from '../../shared/util/unsubscribable';

@Component({
  selector: 'app-income-registration-form',
  templateUrl: './income-registration-form.component.html',
  styleUrls: ['./income-registration-form.component.css']
})
export class IncomeRegistrationFormComponent extends Unsubscribable implements OnInit {

  income = new Income();
  realms: Realm[];

  constructor(private incomeService: IncomeService, private realmService: RealmService) {
    super();
  }

  ngOnInit() {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  register() {
    this.incomeService.createIncome(this.income).subscribe();
  }

}
