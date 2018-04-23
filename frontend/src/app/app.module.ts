import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { BeerListComponent } from './beer-list/beer-list.component';
import {BeerService} from './shared/beer/beer.service';
import { PlayerRegistrationFormComponent } from './player-registration-form/player-registration-form.component';
import { PlayerService } from './services/player.service';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    BeerListComponent,
    PlayerRegistrationFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BeerService, PlayerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
