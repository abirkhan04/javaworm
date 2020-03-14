import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestInvokerComponent } from './test-invoker.component';

describe('TestInvokerComponent', () => {
  let component: TestInvokerComponent;
  let fixture: ComponentFixture<TestInvokerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestInvokerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestInvokerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
