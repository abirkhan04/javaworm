import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent {

  @Input()
  // tslint:disable-next-line: no-inferrable-types
  public message: string = 'Test Message';

  constructor() { }

}
