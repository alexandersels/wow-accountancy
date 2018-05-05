import { Component, OnInit } from '@angular/core';
import { RealmService } from '../../shared/services/realm.service';
import { Realm } from '../../shared/models/realm.model';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-realm-list',
  templateUrl: './realm-list.component.html',
  styleUrls: ['./realm-list.component.scss']
})
export class RealmListComponent extends Unsubscribe implements OnInit {

  realms: Realm[];
  searchText: string;

  sortType: string;
  sortReverse: boolean;

  constructor(private realmService: RealmService) {
    super();
  }

  ngOnInit() {
    this.getRealms();
  }

  getRealms(): void {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  setSortType(sortType: string) {
    this.sortType = sortType;
    this.sortReverse = !this.sortReverse;
  }

}
