import { Component, Input, OnInit } from '@angular/core';
import { Player } from '../shared/models/player.model';
import { ActivatedRoute } from '@angular/router';
import { PlayerService } from '../services/player.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-player-detail',
  templateUrl: './player-detail.component.html',
  styleUrls: ['./player-detail.component.css']
})
export class PlayerDetailComponent implements OnInit {

  @Input() player: Player;

  constructor(
    private route: ActivatedRoute,
    private service: PlayerService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getPlayer();
  }

  getPlayer(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.service.getPlayer(id).subscribe(player => this.player = player);
  }

  goBack(): void {
    this.location.back();
  }



}
