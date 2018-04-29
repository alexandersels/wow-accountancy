import { Component, OnInit } from '@angular/core';
import { Realm } from '../../shared/models/realm.model';
import { PlayerService } from '../../shared/services/player.service';
import { RealmService } from '../../shared/services/realm.service';
import { Player } from '../../shared/models/player.model';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-realm-registration-form',
  templateUrl: './realm-registration-form.component.html',
  styleUrls: ['./realm-registration-form.component.scss']
})
export class RealmRegistrationFormComponent extends Unsubscribe implements OnInit {

  model = new Realm();
  players: Player[];

  constructor(private playerService: PlayerService,
              private realmService: RealmService) {
    super();
  }

  ngOnInit() {
    this.getPlayers();
  }

  getPlayers(): void {
    this.playerService.getPlayers()
      .subscribe(users => this.players = users);
  }

  register() {
    this.realmService.createRealm(this.model).subscribe();
  }

}
