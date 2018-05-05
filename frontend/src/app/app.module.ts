import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PlayerRegistrationFormComponent } from './Player/player-registration-form/player-registration-form.component';
import { FormsModule } from '@angular/forms';
import { PlayerListComponent } from './Player/player-list/player-list.component';
import { AppRoutingModule } from './/app-routing.module';
import { PlayerDetailComponent } from './Player/player-detail/player-detail.component';
import { RealmRegistrationFormComponent } from './Realm/realm-registration-form/realm-registration-form.component';
import { RealmListComponent } from './Realm/realm-list/realm-list.component';
import { RealmDetailComponent } from './Realm/realm-detail/realm-detail.component';
import { IncomeRegistrationFormComponent } from './Income/income-registration-form/income-registration-form.component';
import { IncomeDetailComponent } from './Income/income-detail/income-detail.component';
import { IncomeListComponent } from './Income/income-list/income-list.component';
import { PaymentRegistrationFormComponent } from './Payment/payment-registration-form/payment-registration-form.component';
import { PaymentDetailComponent } from './Payment/payment-detail/payment-detail.component';
import { PaymentListComponent } from './Payment/payment-list/payment-list.component';
import { GoldPerServerComponent } from './gold-per-server/gold-per-server.component';
import { SharedModule } from './shared/shared.module';
import { TeamRegistrationFormComponent } from './team/team-registration-form/team-registration-form.component';
import { TeamListComponent } from './team/team-list/team-list.component';
import { TeamDetailComponent } from './team/team-detail/team-detail.component';
import { SplitComponent } from './split/split.component';
import { HomeComponent } from './home/home.component';
import { RealmSearchFilter } from './pipes/realm.search';
import { RealmSort } from './pipes/realm.sort';
import { PlayerSearchFilter } from './pipes/player.search';
import { SplitSearchFilter } from './pipes/split.search';
import { GoldPerServerSearchFilter } from './pipes/goldperservers.search';
import { IncomesSearchFilter } from './pipes/incomes.search';
import { PaymentSearchFilter } from './pipes/payment.search';
import { TeamSearchFilter } from './pipes/team.search';


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
    GoldPerServerComponent,
    TeamRegistrationFormComponent,
    TeamListComponent,
    TeamDetailComponent,
    SplitComponent,
    HomeComponent,
    RealmSearchFilter,
    PlayerSearchFilter,
    SplitSearchFilter,
    GoldPerServerSearchFilter,
    IncomesSearchFilter,
    PaymentSearchFilter,
    TeamSearchFilter,
    RealmSort
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule.forRoot(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
