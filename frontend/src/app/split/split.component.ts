import { Component } from '@angular/core';
import { Split } from '../shared/models/split.model';
import { SplitService } from '../shared/services/split.service';
import { ListComponentBase } from '../shared/parents/listComponentBase';

@Component({
  selector: 'app-split',
  templateUrl: './split.component.html',
  styleUrls: ['./split.component.scss']
})
export class SplitComponent extends ListComponentBase {

  splits: Split[];
  selectedSplit: Split;

  constructor(private splitService: SplitService) {
    super('name');
  }

  ngOnInit() {
    this.fetchSplits();
  }

  fetchSplits() {
    this.splitService.getSplits().subscribe(splits => this.splits = splits);
  }

  setSelectedSplit(selectedSplit: Split) {
    this.selectedSplit = selectedSplit;
  }

}
