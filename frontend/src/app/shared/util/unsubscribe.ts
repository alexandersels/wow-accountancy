import { OnDestroy } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import 'rxjs/add/operator/takeUntil';

export class Unsubscribe implements OnDestroy {

  ngUnsubscribe$: BehaviorSubject<object> = new BehaviorSubject<object>(undefined);

  ngOnDestroy(): void {
    this.ngUnsubscribe$.next(null);
  }

}
