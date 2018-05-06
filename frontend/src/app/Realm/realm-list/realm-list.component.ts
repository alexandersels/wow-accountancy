import { Component, OnInit } from '@angular/core';
import { RealmService } from '../../shared/services/realm.service';
import { Realm } from '../../shared/models/realm.model';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { ListComponentBase } from '../../shared/parents/listComponentBase';

@Component({
  selector: 'app-realm-list',
  templateUrl: './realm-list.component.html',
  styleUrls: ['./realm-list.component.scss']
})
export class RealmListComponent extends ListComponentBase {

  realms: Realm[];

  selectedRealm: Realm;

  constructor(private realmService: RealmService) {
    super("name");
  }

  ngOnInit() {
    this.getRealms();
  }

  getRealms(): void {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  setSelectedRealm(selectedRealm: Realm) {
    this.selectedRealm = selectedRealm;
  }

}
