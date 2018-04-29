import { Component, OnInit } from '@angular/core';
import { Unsubscribe } from '../shared/util/unsubscribe';
import { Split } from '../shared/models/split.model';
import { SplitService } from '../shared/services/split.service';

@Component({
  selector: 'app-split',
  templateUrl: './split.component.html',
  styleUrls: ['./split.component.css']
})
export class SplitComponent extends Unsubscribe implements OnInit {

  public splits: Split[];

  constructor(private splitService: SplitService) {
    super();
  }

  ngOnInit() {
    this.fetchSplits();
  }

  fetchSplits() {
    this.splitService.getSplits().subscribe(splits => this.splits = splits);
  }

}
