import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrarComponent } from './orar.component';

describe('OrarComponent', () => {
  let component: OrarComponent;
  let fixture: ComponentFixture<OrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
