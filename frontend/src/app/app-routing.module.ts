import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerRegistrationFormComponent } from './player-registration-form/player-registration-form.component';
import { PlayerDetailComponent } from './player-detail/player-detail.component';
import { RealmRegistrationFormComponent } from './realm-registration-form/realm-registration-form.component';
import { RealmListComponent } from './realm-list/realm-list.component';
import { RealmDetailComponent } from './realm-detail/realm-detail.component';
import { IncomeRegistrationFormComponent } from './income-registration-form/income-registration-form.component';
import { IncomeDetailComponent } from './income-detail/income-detail.component';
import { IncomeListComponent } from './income-list/income-list.component';

const routes: Routes = [
  {path: 'availablePlayers', component: PlayerListComponent},
  {path: 'registerPlayer', component: PlayerRegistrationFormComponent},
  {path: 'player/:id', component: PlayerDetailComponent},
  {path: 'registerRealms', component: RealmRegistrationFormComponent},
  {path: 'availableRealms', component: RealmListComponent},
  {path: 'realm/:id', component: RealmDetailComponent},
  {path: 'registerIncome', component: IncomeRegistrationFormComponent},
  {path: 'availableIncomes', component: IncomeListComponent},
  {path: 'income/:id', component: IncomeDetailComponent}
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})


export class AppRoutingModule {
}
