import { Component, Input, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { IncomeService } from '../services/income.service';
import { Income } from '../shared/models/income.model';

@Component({
  selector: 'app-income-detail',
  templateUrl: './income-detail.component.html',
  styleUrls: ['./income-detail.component.css']
})
export class IncomeDetailComponent implements OnInit {

  @Input() income: Income;

  constructor(
    private route: ActivatedRoute,
    private service: IncomeService,
    private location: Location
  ) {
  }

  ngOnInit() {
    this.getIncome();
  }

  getIncome(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.service.getIncome(id).subscribe(income => this.income = income);
  }

  goBack(): void {
    this.location.back();
  }


}
