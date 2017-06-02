import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AprovadorComponent } from './aprovador.component';

describe('AprovadorComponent', () => {
  let component: AprovadorComponent;
  let fixture: ComponentFixture<AprovadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AprovadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AprovadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
