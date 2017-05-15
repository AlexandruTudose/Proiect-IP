import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CereriInregistrareComponent } from './cereri-inregistrare.component';

describe('CereriInregistrareComponent', () => {
  let component: CereriInregistrareComponent;
  let fixture: ComponentFixture<CereriInregistrareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CereriInregistrareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CereriInregistrareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
