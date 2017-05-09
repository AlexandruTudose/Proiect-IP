import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfisComponent } from './afis.component';

describe('AfisComponent', () => {
  let component: AfisComponent;
  let fixture: ComponentFixture<AfisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
