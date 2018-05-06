import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../../shared/services/player.service';
import { Player } from '../../shared/models/player.model';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { ListComponentBase } from '../../shared/parents/listComponentBase';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.scss']
})
export class PlayerListComponent extends ListComponentBase {

  players: Player[];

  constructor(private service: PlayerService) {
    super("name");
  }

  ngOnInit() {
    this.getPlayers();
  }

  getPlayers(): void {
    this.service.getPlayers().subscribe(players => this.players = players);
  }
}
