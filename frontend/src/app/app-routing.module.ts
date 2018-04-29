import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './Player/player-list/player-list.component';
import { PlayerRegistrationFormComponent } from './Player/player-registration-form/player-registration-form.component';
import { PlayerDetailComponent } from './Player/player-detail/player-detail.component';
import { RealmRegistrationFormComponent } from './Realm/realm-registration-form/realm-registration-form.component';
import { RealmListComponent } from './Realm/realm-list/realm-list.component';
import { RealmDetailComponent } from './Realm/realm-detail/realm-detail.component';
import { IncomeRegistrationFormComponent } from './Income/income-registration-form/income-registration-form.component';
import { IncomeDetailComponent } from './Income/income-detail/income-detail.component';
import { IncomeListComponent } from './Income/income-list/income-list.component';
import { PaymentRegistrationFormComponent } from './Payment/payment-registration-form/payment-registration-form.component';
import { PaymentListComponent } from './Payment/payment-list/payment-list.component';
import { PaymentDetailComponent } from './Payment/payment-detail/payment-detail.component';
import { GoldPerServerComponent } from './gold-per-server/gold-per-server.component';
import { TeamRegistrationFormComponent } from './team/team-registration-form/team-registration-form.component';
import { TeamListComponent } from './team/team-list/team-list.component';
import { TeamDetailComponent } from './team/team-detail/team-detail.component';
import { SplitComponent } from './split/split.component';

const routes: Routes = [
  {path: 'availablePlayers', component: PlayerListComponent},
  {path: 'registerPlayer', component: PlayerRegistrationFormComponent},
  {path: 'player/:id', component: PlayerDetailComponent},
  {path: 'registerRealms', component: RealmRegistrationFormComponent},
  {path: 'availableRealms', component: RealmListComponent},
  {path: 'realm/:id', component: RealmDetailComponent},
  {path: 'registerIncome', component: IncomeRegistrationFormComponent},
  {path: 'availableIncomes', component: IncomeListComponent},
  {path: 'income/:id', component: IncomeDetailComponent},
  {path: 'registerPayment', component: PaymentRegistrationFormComponent},
  {path: 'availablePayments', component: PaymentListComponent},
  {path: 'payment/:id', component: PaymentDetailComponent},
  {path: 'availableGold', component: GoldPerServerComponent},
  {path: 'registerTeam', component: TeamRegistrationFormComponent},
  {path: 'availableTeams', component: TeamListComponent},
  {path: 'team/:id', component: TeamDetailComponent},
  {path: 'split', component: SplitComponent},

]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})


export class AppRoutingModule {
}
