import { Component, OnInit } from '@angular/core';
import { TestClass } from '../app-interface';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss']
})
export class ParentComponent {

  public testObject: TestClass = {id: '1', name: 'test name', value: 'test Value'};

  constructor() { }

}
