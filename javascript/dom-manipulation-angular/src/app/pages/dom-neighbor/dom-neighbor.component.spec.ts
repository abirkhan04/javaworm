import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DomNeighborComponent } from './dom-neighbor.component';

describe('DomNeighborComponent', () => {
  let component: DomNeighborComponent;
  let fixture: ComponentFixture<DomNeighborComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DomNeighborComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DomNeighborComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
