import { Component, OnInit } from '@angular/core';
import { Income } from '../../shared/models/income.model';
import { IncomeService } from '../../shared/services/income.service';
import { Unsubscribable } from '../../shared/util/unsubscribable';

@Component({
  selector: 'app-income-list',
  templateUrl: './income-list.component.html',
  styleUrls: ['./income-list.component.css']
})
export class IncomeListComponent extends Unsubscribable implements OnInit {

  incomes: Income[];

  constructor(private service: IncomeService) {
    super();
  }

  ngOnInit() {
    this.getIncomes();
  }

  getIncomes(): void {
    this.service.getIncomes()
      .takeUntil(this.ngUnsubscribe$)
      .subscribe(incomes => this.incomes = incomes);
  }
}
