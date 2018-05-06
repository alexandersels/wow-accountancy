import { OnInit } from '@angular/core';
import { Unsubscribe } from '../util/unsubscribe';

export abstract class ListComponentBase extends Unsubscribe implements OnInit {

  searchText: string;
  sortType: string;
  sortReverse = false;

  protected constructor(sortType: string) {
    super();
    this.sortType = sortType;
  }

  abstract ngOnInit();

  shouldDisplaySortIcon(name: string, isUpArrow: boolean): boolean {
    return this.sortType == name && isUpArrow == this.sortReverse;
  }

  setSortType(sortType: string) {
    this.sortType = sortType;
    this.sortReverse = !this.sortReverse;
  }

}
