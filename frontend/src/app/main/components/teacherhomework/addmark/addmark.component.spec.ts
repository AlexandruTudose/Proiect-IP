/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AddmarkComponent } from './addmark.component';

describe('AddmarkComponent', () => {
  let component: AddmarkComponent;
  let fixture: ComponentFixture<AddmarkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmarkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmarkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
