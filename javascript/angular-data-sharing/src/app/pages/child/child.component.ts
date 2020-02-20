import { Component, OnInit, Input } from '@angular/core';
import { TestClass } from '../app-interface';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss']
})
export class ChildComponent {

  @Input() public inputObject: TestClass;
  constructor() { }

}
