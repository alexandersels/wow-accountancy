import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerRegistrationFormComponent } from './player-registration-form/player-registration-form.component';
import { PlayerDetailComponent } from './player-detail/player-detail.component';
import { RealmRegistrationFormComponent } from './realm-registration-form/realm-registration-form.component';
import { RealmListComponent } from './realm-list/realm-list.component';
import { RealmDetailComponent } from './realm-detail/realm-detail.component';

const routes: Routes = [
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  {path: 'availablePlayers', component: PlayerListComponent},
  {path: 'registerPlayer', component:PlayerRegistrationFormComponent},
  {path: 'player/:id', component: PlayerDetailComponent},
  {path: 'registerRealms', component:RealmRegistrationFormComponent},
  {path: 'availableRealms', component: RealmListComponent},
  {path: 'realm/:id', component: RealmDetailComponent}
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})



export class AppRoutingModule {
}
