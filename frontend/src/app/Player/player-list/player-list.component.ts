import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../../shared/services/player.service';
import { Player } from '../../shared/models/player.model';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.scss']
})
export class PlayerListComponent extends Unsubscribe implements OnInit {

  searchText: string;
  players: Player[];

  constructor(private service: PlayerService) {
    super();
  }

  ngOnInit() {
    this.getPlayers();
  }

  getPlayers(): void {
    this.service.getPlayers().subscribe(players => this.players = players);
  }
}
