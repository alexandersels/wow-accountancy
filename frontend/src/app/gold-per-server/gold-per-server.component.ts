import { Component } from '@angular/core';
import { AvailableGoldService } from '../shared/services/available-gold.service';
import { AvailableGold } from '../shared/models/available-gold.model';
import { ListComponentBase } from '../shared/parents/listComponentBase';

@Component({
  selector: 'app-gold-per-server',
  templateUrl: './gold-per-server.component.html',
  styleUrls: ['./gold-per-server.component.scss']
})
export class GoldPerServerComponent extends ListComponentBase {

  availableGold: AvailableGold;
  selectedGold: AvailableGold;

  constructor(private availableGoldService: AvailableGoldService) {
    super('realm');
  }

  ngOnInit() {
    this.getAvailableGold();
  }

  getAvailableGold() {
    this.availableGoldService.getAvailableGold()
      .subscribe(availableGold => this.availableGold = availableGold)
  }

  setSelectedGold(selectedGold: AvailableGold) {
    this.selectedGold = selectedGold;
  }

}
