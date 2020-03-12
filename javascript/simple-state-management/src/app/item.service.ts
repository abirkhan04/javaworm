import { Injectable } from '@angular/core';
import { Observable, of, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  public readonly behaviourItems: BehaviorSubject<Item[]> = new BehaviorSubject<Item[]>([]);

  constructor() { }

  public addItem(item: Item): Observable<Item[]> {
    let items = this.behaviourItems.getValue();
    items = [...items , item];
    this.behaviourItems.next(items);
    return this.behaviourItems;
  }

  public getItems(): Observable<Item[]> {
    return this.behaviourItems;
  }

  public deleteItem(id: string): Observable<Item[]> {
    const items = this.behaviourItems.getValue();
    items.splice(items.findIndex((item) => item.id === id), 1 );
    return this.behaviourItems;
  }

  public saveItem(updatedItem: Item): Observable<Item[]> {
    const items = this.behaviourItems.getValue();
    items.find((item) => item.id === updatedItem.id)[0] = updatedItem;
    return this.behaviourItems;
  }
}

export interface Item {
  id: string;
  name: string;
}
