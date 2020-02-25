import { Component, OnInit } from '@angular/core';
import { DataSharingService } from '../data-sharing.service';

@Component({
  selector: 'app-parent2',
  templateUrl: './parent2.component.html',
  styleUrls: ['./parent2.component.scss']
})
export class Parent2Component implements OnInit {

  public objectFromParent1: any ;
  constructor(private dataSharingService: DataSharingService) { }

  public ngOnInit(): void {
    this.objectFromParent1 = window.history.state.data;
    this.dataSharingService.message.next("Test Message From Parent2");
  }

}
