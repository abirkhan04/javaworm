import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { TestClass } from '../app-interface';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss']
})
export class ChildComponent {

  @Input() public inputObject: TestClass;
  @Output() public dataSharingEvent: EventEmitter<any> = new EventEmitter<any>();
  constructor() { }

  public sendData(value: string): void {
    this.dataSharingEvent.emit({data: value});
  }

}
