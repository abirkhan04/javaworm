import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { TestClass } from '../app-interface';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ParentComponent {

  public testObject: TestClass = {id: '1', name: 'test name', value: 'test Value'};
  public childItem: any ;

  constructor(private changeDetector: ChangeDetectorRef) { }

  public getChildData(data: any): void {
    this.childItem  = data;
    this.changeDetector.detectChanges();
  }
}
