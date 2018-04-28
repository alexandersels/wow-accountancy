import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { PlayerRegistrationFormComponent } from './player-registration-form/player-registration-form.component';
import { PlayerService } from './services/player.service';
import { FormsModule } from '@angular/forms';
import { PlayerListComponent } from './player-list/player-list.component';
import { AppRoutingModule } from './/app-routing.module';
import { PlayerDetailComponent } from './player-detail/player-detail.component';
import { RealmRegistrationFormComponent } from './realm-registration-form/realm-registration-form.component';
import { RealmService } from './services/realm.service';
import { RealmListComponent } from './realm-list/realm-list.component';
import { RealmDetailComponent } from './realm-detail/realm-detail.component';
import { IncomeRegistrationFormComponent } from './income-registration-form/income-registration-form.component';
import { IncomeService } from './services/income.service';
import { IncomeDetailComponent } from './income-detail/income-detail.component';
import { IncomeListComponent } from './income-list/income-list.component';


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
    IncomeListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
  ],
  providers: [PlayerService, RealmService, IncomeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
