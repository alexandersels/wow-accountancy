import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncomeRegistrationFormComponent } from './income-registration-form.component';

describe('IncomeRegistrationFormComponent', () => {
  let component: IncomeRegistrationFormComponent;
  let fixture: ComponentFixture<IncomeRegistrationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncomeRegistrationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncomeRegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
