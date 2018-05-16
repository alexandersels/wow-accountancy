import { Component } from '@angular/core';
import { RealmService } from '../../shared/services/realm.service';
import { Realm } from '../../shared/models/realm.model';
import { ListComponentBase } from '../../shared/parents/listComponentBase';
import { Player } from '../../shared/models/player.model';
import { PlayerService } from '../../shared/services/player.service';

@Component({
  selector: 'app-realm-list',
  templateUrl: './realm-list.component.html',
  styleUrls: ['./realm-list.component.scss']
})
export class RealmListComponent extends ListComponentBase {

  realms: Realm[];
  players: Player[];

  selectedRealm: Realm;

  constructor(private realmService: RealmService,
              private playerService: PlayerService) {
    super('name');
  }

  ngOnInit() {
    this.loadDate();
  }

  loadDate(): void {
    this.loadRealms();
  }

  loadRealms(): void {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  setSelectedRealm(selectedRealm: Realm) {
    this.selectedRealm = selectedRealm;
  }

}
