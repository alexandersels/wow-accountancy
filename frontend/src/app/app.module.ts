import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PlayerRegistrationFormComponent } from './Player/player-registration-form/player-registration-form.component';
import { PlayerService } from './shared/services/player.service';
import { FormsModule } from '@angular/forms';
import { PlayerListComponent } from './Player/player-list/player-list.component';
import { AppRoutingModule } from './/app-routing.module';
import { PlayerDetailComponent } from './Player/player-detail/player-detail.component';
import { RealmRegistrationFormComponent } from './Realm/realm-registration-form/realm-registration-form.component';
import { RealmService } from './shared/services/realm.service';
import { RealmListComponent } from './Realm/realm-list/realm-list.component';
import { RealmDetailComponent } from './Realm/realm-detail/realm-detail.component';
import { IncomeRegistrationFormComponent } from './Income/income-registration-form/income-registration-form.component';
import { IncomeService } from './shared/services/income.service';
import { IncomeDetailComponent } from './Income/income-detail/income-detail.component';
import { IncomeListComponent } from './Income/income-list/income-list.component';
import { PaymentRegistrationFormComponent } from './Payment/payment-registration-form/payment-registration-form.component';
import { PaymentDetailComponent } from './Payment/payment-detail/payment-detail.component';
import { PaymentListComponent } from './Payment/payment-list/payment-list.component';
import { PaymentService } from './shared/services/payment.service';
import { GoldPerServerComponent } from './gold-per-server/gold-per-server.component';
import { SharedModule } from './shared/shared.module';


@NgModule({
  declarations: [
    AppComponent,
    PlayerRegistrationFormComponent,
    PlayerListComponent,
    PlayerDetailComponent,
    RealmRegistrationFormComponent,
    RealmListComponent,
    RealmDetailComponent,
    IncomeRegistrationFormComponent,
    IncomeDetailComponent,
    IncomeListComponent,
    PaymentRegistrationFormComponent,
    PaymentDetailComponent,
    PaymentListComponent,
    GoldPerServerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    SharedModule.forRoot()
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
