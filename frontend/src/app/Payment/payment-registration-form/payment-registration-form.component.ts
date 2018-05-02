import { Component, OnInit } from '@angular/core';
import { Payment } from '../../shared/models/payment.model';
import { Player } from '../../shared/models/player.model';
import { Realm } from '../../shared/models/realm.model';
import { RealmService } from '../../shared/services/realm.service';
import { PlayerService } from '../../shared/services/player.service';
import { PaymentService } from '../../shared/services/payment.service';
import { Unsubscribe } from '../../shared/util/unsubscribe';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-payment-registration-form',
  templateUrl: './payment-registration-form.component.html',
  styleUrls: ['./payment-registration-form.component.scss']
})
export class PaymentRegistrationFormComponent extends Unsubscribe implements OnInit {

  payment = new Payment();

  players: Player[];
  realms: Realm[];

  form: FormGroup;

  playerName = new FormControl('', Validators.required);
  realmName = new FormControl('', Validators.required);
  priceName = new FormControl('', Validators.required);

  constructor(private realmService: RealmService,
              private playerService: PlayerService,
              private paymentService: PaymentService,
              private fb: FormBuilder) {
    super();

    this.form = this.fb.group(
      {
        'playerName': this.playerName,
        'realmName': this.realmName,
        'priceName': this.priceName
      }
    );

  }

  ngOnInit() {
    this.loadRealms();
    this.loadPlayers();
  }

  loadRealms(): void {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

  loadPlayers(): void {
    this.playerService.getPlayers().subscribe(players => this.players = players);
  }

  register() {
    this.paymentService.createPayment(this.payment)
      .subscribe();
  }
}
