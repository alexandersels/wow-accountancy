import { Component, OnInit } from '@angular/core';
import { Player } from '../../shared/models/player.model';
import { PlayerService } from '../../shared/services/player.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';

@Component({
  selector: 'app-player-registration-form',
  templateUrl: './player-registration-form.component.html',
  styleUrls: ['./player-registration-form.component.scss']
})
export class PlayerRegistrationFormComponent extends Unsubscribe implements OnInit {

  model = new Player();

  constructor(private service: PlayerService) {
    super();
  }

  ngOnInit() {
  }

  register() {
    this.service.createPlayer(this.model)
      .subscribe();
  }

}
