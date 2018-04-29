import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentRegistrationFormComponent } from './payment-registration-form.component';

describe('PaymentRegistrationFormComponent', () => {
  let component: PaymentRegistrationFormComponent;
  let fixture: ComponentFixture<PaymentRegistrationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaymentRegistrationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentRegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
