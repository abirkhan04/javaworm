import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  public items: Item[] = [];

  constructor() { }

  public addItem(item: Item): Observable<Item[]> {
    this.items = [...this.items, item];
    return of(this.items);
  }

  public getItems(): Observable<Item[]> {
    return of(this.items);
  }

  public deleteItem(id: string) : Observable<Item[]> {
    this.items = this.items.splice(this.items.findIndex((item)=> { item.id === id}), 0 );
    return of(this.items);
  }

  public saveItem(updatedItem: Item) : Observable<Item[]> {
    this.items.find((item)=>item.id === updatedItem.id)[0] = updatedItem;
    return of(this.items);
  }

}

export interface Item {
  id: string;
  name: string;
}
