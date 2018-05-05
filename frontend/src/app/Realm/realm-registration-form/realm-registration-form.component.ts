import { Component, OnInit } from '@angular/core';
import { Realm } from '../../shared/models/realm.model';
import { PlayerService } from '../../shared/services/player.service';
import { RealmService } from '../../shared/services/realm.service';
import { Player } from '../../shared/models/player.model';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-realm-registration-form',
  templateUrl: './realm-registration-form.component.html',
  styleUrls: ['./realm-registration-form.component.scss']
})
export class RealmRegistrationFormComponent extends Unsubscribe implements OnInit {

  model = new Realm();
  players: Player[];

  form: FormGroup;

  playerName = new FormControl('', Validators.required);
  realmName = new FormControl('', Validators.required);
  regionName = new FormControl('', Validators.required);

  constructor(private playerService: PlayerService,
              private realmService: RealmService,
              private fb: FormBuilder,
              private location: Location) {
    super();

    this.form = fb.group(
      {
        'realmName': this.realmName,
        'playerName': this.playerName,
        'regionName': this.regionName
      }
    )
  }

  ngOnInit() {
    this.getPlayers();
  }

  getPlayers(): void {
    this.playerService.getPlayers().subscribe(users => this.players = users);
  }

  register() {
    this.realmService.createRealm(this.model).subscribe();
    this.goBack();
  }

  goBack(): void {
    this.location.back();
  }

}
