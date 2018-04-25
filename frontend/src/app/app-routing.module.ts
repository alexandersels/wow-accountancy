import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerRegistrationFormComponent } from './player-registration-form/player-registration-form.component';
import { PlayerDetailComponent } from './player-detail/player-detail.component';

const routes: Routes = [
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  {path: 'availablePlayers', component: PlayerListComponent},
  {path: 'registerPlayer', component:PlayerRegistrationFormComponent},
  {path: 'player/:id', component: PlayerDetailComponent}
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})



export class AppRoutingModule {
}
