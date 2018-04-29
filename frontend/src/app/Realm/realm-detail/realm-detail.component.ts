import { Component, OnInit } from '@angular/core';
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

  realm: Realm;
  player: Player;

  constructor(private route: ActivatedRoute,
              private realmService: RealmService,
              private playerService: PlayerService,
              private location: Location)
  {
    super();
  }

  ngOnInit() {
    this.loadContent();
  }

  loadContent(): void {
    const name = this.route.snapshot.paramMap.get('id');
    this.realmService.getRealm(name).subscribe(realm => this.loadRealm(realm));
  }

  loadRealm(realm: Realm): void {
    this.realm = realm;
    this.loadPlayer(realm);
  }

  loadPlayer(realm: Realm): void {
    this.realm = realm;
    this.playerService.getPlayer(realm.player)
      .subscribe(player => this.player = player);
  }

  goBack(): void {
    this.location.back();
  }

}
