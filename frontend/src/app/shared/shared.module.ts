import { ModuleWithProviders, NgModule } from '@angular/core';
import { PlayerService } from './services/player.service';
import { PaymentService } from './services/payment.service';
import { RealmService } from './services/realm.service';
import { IncomeService } from './services/income.service';
import { AvailableGoldService } from './services/available-gold.service';
import { TeamService } from './services/team.service';
import { SplitService } from './services/split.service';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule, MatIconModule, MatListModule } from '@angular/material';


const MODULES = [
  MatSidenavModule,
  MatListModule,
  MatIconModule,
  MatButtonModule
];

const COMPONENTS = [];

const SERVICES = [
  PlayerService,
  RealmService,
  IncomeService,
  PaymentService,
  AvailableGoldService,
  TeamService,
  SplitService
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
