import { Component, OnInit } from '@angular/core';
import { Payment } from '../../shared/models/payment.model';
import { Player } from '../../shared/models/player.model';
import { Realm } from '../../shared/models/realm.model';
import { RealmService } from '../../shared/services/realm.service';
import { PlayerService } from '../../shared/services/player.service';
import { PaymentService } from '../../shared/services/payment.service';
import { Unsubscribable } from '../../shared/util/unsubscribable';

@Component({
  selector: 'app-payment-registration-form',
  templateUrl: './payment-registration-form.component.html',
  styleUrls: ['./payment-registration-form.component.css']
})
export class PaymentRegistrationFormComponent extends Unsubscribable implements OnInit {

  payment = new Payment();

  players: Player[];
  realms: Realm[];

  constructor(private realmService: RealmService,
              private playerService: PlayerService,
              private paymentService: PaymentService) {
    super();
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
    this.paymentService.createPayment(this.payment).subscribe();
  }
}
