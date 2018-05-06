import { Component, OnInit } from '@angular/core';
import { Income } from '../../shared/models/income.model';
import { IncomeService } from '../../shared/services/income.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { ListComponentBase } from '../../shared/parents/listComponentBase';

@Component({
  selector: 'app-income-list',
  templateUrl: './income-list.component.html',
  styleUrls: ['./income-list.component.scss']
})
export class IncomeListComponent extends ListComponentBase {

  incomes: Income[];

  constructor(private service: IncomeService) {
    super("team");
  }

  ngOnInit() {
    this.getIncomes();
  }

  getIncomes(): void {
    this.service.getIncomes()
      .subscribe(incomes => this.incomes = incomes);
  }
}
