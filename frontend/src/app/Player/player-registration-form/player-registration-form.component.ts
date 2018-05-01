import { Component, OnInit } from '@angular/core';
import { Player } from '../../shared/models/player.model';
import { PlayerService } from '../../shared/services/player.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-player-registration-form',
  templateUrl: './player-registration-form.component.html',
  styleUrls: ['./player-registration-form.component.scss']
})
export class PlayerRegistrationFormComponent extends Unsubscribe implements OnInit {

  model = new Player();
  form: FormGroup;
  playerName = new FormControl("", Validators.required);

  constructor(private service: PlayerService,
              private fb: FormBuilder) {
    super();

    this.form = fb.group(
      {
        "playerName": this.playerName,
      }
    )

  }

  ngOnInit() {
  }

  register() {
    this.model.name = this.playerName.value;
    this.service.createPlayer(this.model).subscribe();
  }

}
