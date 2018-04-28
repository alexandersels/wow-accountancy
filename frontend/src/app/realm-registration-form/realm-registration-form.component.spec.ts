import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RealmRegistrationFormComponent } from './realm-registration-form.component';

describe('RealmRegistrationFormComponent', () => {
  let component: RealmRegistrationFormComponent;
  let fixture: ComponentFixture<RealmRegistrationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RealmRegistrationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RealmRegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
