import { Component, Input, OnInit } from '@angular/core';
import { Player } from '../../shared/models/player.model';
import { ActivatedRoute } from '@angular/router';
import { PlayerService } from '../../shared/services/player.service';
import { Location } from '@angular/common';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-player-detail',
  templateUrl: './player-detail.component.html',
  styleUrls: ['./player-detail.component.css']
})
export class PlayerDetailComponent extends Unsubscribe implements OnInit {

  @Input() player: Player;

  constructor(
    private route: ActivatedRoute,
    private service: PlayerService,
    private location: Location
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPlayer();
  }

  getPlayer(): void {
    const name = this.route.snapshot.paramMap.get('id');
    this.service.getPlayer(name)
      .subscribe(player => this.player = player);
  }

  goBack(): void {
    this.location.back();
  }



}
