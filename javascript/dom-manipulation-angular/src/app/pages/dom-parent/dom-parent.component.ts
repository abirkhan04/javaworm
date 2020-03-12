import { Component, OnInit, ElementRef,
    ViewChild, ViewChildren, QueryList, AfterViewInit, ContentChildren, ContentChild, AfterContentInit } from '@angular/core';

@Component({
  selector: 'app-dom-parent',
  templateUrl: './dom-parent.component.html',
  styleUrls: ['./dom-parent.component.scss']
})
export class DomParentComponent implements OnInit , AfterViewInit, AfterContentInit {

  constructor(private elementRef: ElementRef) { }

  @ViewChild('child', {read: ElementRef, static: true}) child: ElementRef;
  @ViewChildren('p') ps: QueryList<any>;
  @ContentChild('insideNgContent', {read: ElementRef, static: true}) contentChild: ElementRef;

  public ngOnInit(): void {
    console.log('Native Element', this.elementRef.nativeElement);
    console.log('Native Element of a child', this.child.nativeElement);
    console.log('Children here', this.ps);
  }

  public ngAfterViewInit(): void {
     console.log('ps here ', this.ps);
  }

  public ngAfterContentInit(): void {
    console.log('Inside ng-content', this.contentChild);
  }
}
