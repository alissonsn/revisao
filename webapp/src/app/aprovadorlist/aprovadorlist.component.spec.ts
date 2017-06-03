import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AprovadorlistComponent } from './aprovadorlist.component';

describe('AprovadorlistComponent', () => {
  let component: AprovadorlistComponent;
  let fixture: ComponentFixture<AprovadorlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AprovadorlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AprovadorlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
