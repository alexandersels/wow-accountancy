import { Component, OnInit } from '@angular/core';
import { Income } from '../../shared/models/income.model';
import { IncomeService } from '../../shared/services/income.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-income-list',
  templateUrl: './income-list.component.html',
  styleUrls: ['./income-list.component.scss']
})
export class IncomeListComponent extends Unsubscribe implements OnInit {

  incomes: Income[];

  constructor(private service: IncomeService) {
    super();
  }

  ngOnInit() {
    this.getIncomes();
  }

  getIncomes(): void {
    this.service.getIncomes()
      .subscribe(incomes => this.incomes = incomes);
  }
}
