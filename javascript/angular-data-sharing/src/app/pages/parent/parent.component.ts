import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef, ViewChild } from '@angular/core';
import { TestClass } from '../app-interface';
import { ChildComponent } from '../child/child.component';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ParentComponent implements OnInit {

  public testObject: TestClass = {id: '1', name: 'test name', value: 'test Value'};
  public childItemThroughContainer: string;
  public childItem: any;
  @ViewChild(ChildComponent, {static: true}) private child: ChildComponent;

  constructor(private changeDetector: ChangeDetectorRef) { }

  public getChildData(data: any): void {
    this.childItem  = data;
    this.changeDetector.detectChanges();
  }

  public ngOnInit(): void {
    this.childItemThroughContainer = this.child.item;
  }

}
