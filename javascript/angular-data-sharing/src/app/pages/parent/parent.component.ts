import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef, ViewChild } from '@angular/core';
import { TestClass } from '../app-interface';
import { ChildComponent } from '../child/child.component';
import { DataSharingService } from '../data-sharing.service';

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
  public sharedValue: string;

  @ViewChild(ChildComponent, {static: true}) private child: ChildComponent;

  constructor(private dataSharingService: DataSharingService,
    private changeDetector: ChangeDetectorRef) { }

  public getChildData(data: any): void {
    this.childItem  = data;
    this.changeDetector.detectChanges();
  }

  public ngOnInit(): void {
    this.sharedValue = this.dataSharingService.message.getValue(); 
    this.childItemThroughContainer = this.child.item;
  }

}
