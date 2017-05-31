/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { MossComponent } from './moss.component';

describe('MossComponent', () => {
  let component: MossComponent;
  let fixture: ComponentFixture<MossComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MossComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MossComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
