import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoldPerServerComponent } from './gold-per-server.component';

describe('GoldPerServerComponent', () => {
  let component: GoldPerServerComponent;
  let fixture: ComponentFixture<GoldPerServerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoldPerServerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoldPerServerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
