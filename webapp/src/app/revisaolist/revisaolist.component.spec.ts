import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevisaolistComponent } from './revisaolist.component';

describe('RevisaolistComponent', () => {
  let component: RevisaolistComponent;
  let fixture: ComponentFixture<RevisaolistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevisaolistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevisaolistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
