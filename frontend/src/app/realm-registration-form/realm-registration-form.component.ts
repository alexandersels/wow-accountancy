import { Component, OnInit } from '@angular/core';
import { Realm } from '../shared/models/realm.model';
import { PlayerService } from '../services/player.service';
import { RealmService } from '../services/realm.service';
import { Player } from '../shared/models/player.model';

@Component({
  selector: 'app-realm-registration-form',
  templateUrl: './realm-registration-form.component.html',
  styleUrls: ['./realm-registration-form.component.css']
})
export class RealmRegistrationFormComponent implements OnInit {

  model = new Realm();
  players: Player[];

  constructor(private playerService: PlayerService, private realmService: RealmService) {
  }

  ngOnInit() {
    this.getPlayers();
  }

  getPlayers(): void {
    this.playerService.getPlayers().subscribe(users => this.players = users);
  }

  register() {
    this.realmService.createRealm(this.model).subscribe();
  }

}
