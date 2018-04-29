import { OnDestroy } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

export class Unsubscribable implements OnDestroy {
  ngUnsubscribe$: BehaviorSubject<any> = new BehaviorSubject<any>(undefined);

  ngOnDestroy(): void {
    this.ngUnsubscribe$.next(true);
  }

}
