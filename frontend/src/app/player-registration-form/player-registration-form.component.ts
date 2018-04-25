import { Component, OnInit } from '@angular/core';
import { Player } from '../shared/models/player.model';
import { PlayerService } from '../services/player.service';

@Component({
  selector: 'app-player-registration-form',
  templateUrl: './player-registration-form.component.html',
  styleUrls: ['./player-registration-form.component.css']
})
export class PlayerRegistrationFormComponent implements OnInit {

  model = new Player("Alexander");

  constructor(private service: PlayerService) { }

  ngOnInit() {
  }

  register() {
      this.service.createPlayer(this.model).subscribe();
  }

}
