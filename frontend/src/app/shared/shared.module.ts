import { ModuleWithProviders, NgModule } from '@angular/core';
import { PlayerService } from './services/player.service';
import { PaymentService } from './services/payment.service';
import { RealmService } from './services/realm.service';
import { IncomeService } from './services/income.service';
import { AvailableGoldService } from './services/available-gold.service';
import { TeamService } from './services/team.service';
import { SplitService } from './services/split.service';
import { MatInputModule } from '@angular/material/input';
import {ReactiveFormsModule} from "@angular/forms";
import { StatisticsService } from './services/statistics.service';


const MODULES = [
  MatInputModule,
  ReactiveFormsModule
];

const COMPONENTS = [];

const SERVICES = [
  PlayerService,
  RealmService,
  IncomeService,
  PaymentService,
  AvailableGoldService,
  TeamService,
  SplitService,
  StatisticsService
];

const PIPES = [];

const GUARDS = [];

@NgModule({
  imports: [
    ...MODULES
  ],
  exports: [
    ...MODULES,
    ...COMPONENTS,
    ...PIPES
  ],
  declarations: [
    ...COMPONENTS,
    ...PIPES
  ]
})
export class SharedModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SharedModule,
      providers: [...SERVICES, ...GUARDS]
    };
  }
}
