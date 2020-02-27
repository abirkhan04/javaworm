import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DomParentComponent } from './dom-parent.component';

describe('DomParentComponent', () => {
  let component: DomParentComponent;
  let fixture: ComponentFixture<DomParentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DomParentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DomParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
