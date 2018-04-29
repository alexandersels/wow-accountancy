import { ModuleWithProviders, NgModule } from '@angular/core';
import { PlayerService } from './services/player.service';
import { PaymentService } from './services/payment.service';
import { RealmService } from './services/realm.service';
import { IncomeService } from './services/income.service';

const MODULES = [

];

const COMPONENTS = [
];

const SERVICES = [
  PlayerService,
  RealmService,
  IncomeService,
  PaymentService
];

const PIPES = [
];

const GUARDS = [
];

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
