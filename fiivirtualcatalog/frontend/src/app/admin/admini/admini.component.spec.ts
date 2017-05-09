import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminiComponent } from './admini.component';

describe('AdminiComponent', () => {
  let component: AdminiComponent;
  let fixture: ComponentFixture<AdminiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
