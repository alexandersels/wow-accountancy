import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerRegistrationFormComponent } from './player-registration-form.component';

describe('PlayerRegistrationFormComponent', () => {
  let component: PlayerRegistrationFormComponent;
  let fixture: ComponentFixture<PlayerRegistrationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerRegistrationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerRegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
