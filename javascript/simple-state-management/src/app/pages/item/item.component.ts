import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { ItemService, Item } from 'src/app/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ItemComponent implements OnInit {

  public items: Item[];
  public itemOnEdit: Item;

  constructor(private itemService: ItemService,
    private changeDetector: ChangeDetectorRef) { }

  public ngOnInit(): void {
     this.itemService.getItems().subscribe((items)=>{
       this.items = items;
       this.changeDetector.detectChanges();
     });
  }

  public addItem(): void {
    const item : Item = {id: Math.floor(Math.random()*100).toString(), name: 'Test Name ' + Math.floor(Math.random()*100).toString()};
    this.itemService.addItem(item).subscribe((items)=>{
       this.items = items;
       this.changeDetector.detectChanges();
    });
  }

  public delete(id: string) : void {
    this.itemService.deleteItem(id).subscribe((items: Item[])=>{
        this.items = items;
    });
  }

  public edit(item: Item) : void {
    this.itemOnEdit = item;
  }

  public Save(): void {
     this.itemService.saveItem(this.itemOnEdit);
     this.itemOnEdit = null;
  }
}
