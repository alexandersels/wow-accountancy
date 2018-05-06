import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../shared/services/statistics.service';
import { DungeonsStatic } from '../shared/models/statistics/dungeons.static';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  dataTable: any[];
  pieChartData: any;

  totalRuns: number;

  constructor(private service: StatisticsService) {
  }

  ngOnInit() {
    this.service.getDungeonStatistics().subscribe(dungeonsStatistic => this.createPieChart(dungeonsStatistic));
  }

  createPieChart(dungeonsStatistic: DungeonsStatic) {

    this.totalRuns = dungeonsStatistic.totalRuns;
    this.dataTable = [['Task', 'Hours per Day']];

    dungeonsStatistic.dungeons.forEach(
      value =>
      this.dataTable.push([value.dungeonName, value.amountOfRuns]));


    this.pieChartData = {
      chartType: 'PieChart',
      dataTable: this.dataTable,
      options: {'title': 'Tasks'},
    };

  }
}
