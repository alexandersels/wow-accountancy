import { Component, OnInit } from '@angular/core';
import {BeerService} from '../shared/beer/beer.service';

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css']
})
export class BeerListComponent implements OnInit {

  constructor(private beerService: BeerService) { }

  beers: any[];

  ngOnInit() {
    this.beerService.getAll().subscribe(
      data => { this.beers = data; }
    );
  }

}
