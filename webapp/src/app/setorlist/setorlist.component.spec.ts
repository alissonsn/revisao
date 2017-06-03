import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetorlistComponent } from './setorlist.component';

describe('SetorlistComponent', () => {
  let component: SetorlistComponent;
  let fixture: ComponentFixture<SetorlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetorlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetorlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
