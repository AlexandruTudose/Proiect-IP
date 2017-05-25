/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { EditteacherComponent } from './editteacher.component';

describe('EditteacherComponent', () => {
  let component: EditteacherComponent;
  let fixture: ComponentFixture<EditteacherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditteacherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditteacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
