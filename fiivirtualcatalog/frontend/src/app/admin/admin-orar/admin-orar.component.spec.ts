import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOrarComponent } from './admin-orar.component';

describe('AdminOrarComponent', () => {
  let component: AdminOrarComponent;
  let fixture: ComponentFixture<AdminOrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminOrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminOrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
