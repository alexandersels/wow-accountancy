import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RealmService } from '../../shared/services/realm.service';
import { Realm } from '../../shared/models/realm.model';
import { Player } from '../../shared/models/player.model';
import { PlayerService } from '../../shared/services/player.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-realm-detail',
  templateUrl: './realm-detail.component.html',
  styleUrls: ['./realm-detail.component.scss']
})
export class RealmDetailComponent extends Unsubscribe implements OnInit {

  @Input()
  realm: Realm;

  players: Player[];

  constructor(private route: ActivatedRoute,
              private realmService: RealmService,
              private playerService: PlayerService,
              private location: Location) {
    super();
  }

  ngOnInit() {
    this.playerService.getPlayers().subscribe(players => this.players = players);
  }

  goBack(): void {
    this.location.back();
  }

  update(): void {
    this.realmService.updateRealm(this.realm).subscribe();
  }

}
