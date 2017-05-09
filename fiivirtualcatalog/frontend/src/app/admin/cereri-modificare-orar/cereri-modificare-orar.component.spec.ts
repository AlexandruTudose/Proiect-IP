import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CereriModificareOrarComponent } from './cereri-modificare-orar.component';

describe('CereriModificareOrarComponent', () => {
  let component: CereriModificareOrarComponent;
  let fixture: ComponentFixture<CereriModificareOrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CereriModificareOrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CereriModificareOrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
