import { Component, OnInit } from '@angular/core';
import { Income } from '../shared/models/income.model';
import { IncomeService } from '../services/income.service';

@Component({
  selector: 'app-income-list',
  templateUrl: './income-list.component.html',
  styleUrls: ['./income-list.component.css']
})
export class IncomeListComponent implements OnInit {

  incomes: Income[];

  constructor(private service: IncomeService) { }

  ngOnInit() {
    this.getIncomes();
  }

  getIncomes(): void {
    this.service.getIncomes().subscribe(incomes => this.incomes = incomes);
  }
}
