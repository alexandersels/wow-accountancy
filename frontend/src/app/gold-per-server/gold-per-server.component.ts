import { Component, OnInit } from '@angular/core';
import { AvailableGoldService } from '../shared/services/available-gold.service';
import { AvailableGold } from '../shared/models/available-gold.model';
import { Unsubscribe } from '../shared/util/unsubscribe';

@Component({
  selector: 'app-gold-per-server',
  templateUrl: './gold-per-server.component.html',
  styleUrls: ['./gold-per-server.component.scss']
})
export class GoldPerServerComponent extends Unsubscribe implements OnInit {

  searchText: string;
  availableGold: AvailableGold;

  constructor(private availableGoldService: AvailableGoldService) {
    super();
  }

  ngOnInit() {
    this.getAvailableGold();
  }

  getAvailableGold() {
    this.availableGoldService.getAvailableGold()
      .subscribe(availableGold => this.availableGold = availableGold)
  }

}
