import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RenderHtmlUsingRenderer2Component } from './render-html-using-renderer2.component';

describe('RenderingHtmlInRendered2Component', () => {
  let component: RenderHtmlUsingRenderer2Component;
  let fixture: ComponentFixture<RenderHtmlUsingRenderer2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RenderHtmlUsingRenderer2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RenderHtmlUsingRenderer2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
