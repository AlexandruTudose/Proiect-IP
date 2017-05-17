/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FindcourseComponent } from './findcourse.component';

describe('FindcourseComponent', () => {
  let component: FindcourseComponent;
  let fixture: ComponentFixture<FindcourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindcourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindcourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
