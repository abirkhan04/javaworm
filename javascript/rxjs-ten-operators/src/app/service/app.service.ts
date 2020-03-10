import { Injectable } from '@angular/core';
import { Item, Category } from '../app-interfaces';
import { Observable, of, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor() { }

  public getItems(): Observable<Array<Item>> {
    const items: Item[] = Items();
    return of(items);
  }

  public getCategories(): Observable<Category[]> {
    const categories: Category[] =  Categories();
    return of(categories);
  }

  public getCategoryById(id: string): Observable<Category> {
    return of(Categories().find((item) => item.id === id));
  }

  public getItemByCategory(categoryId: string): Observable<Item[]> {
    return of(Items().filter((item) => item.category.id === categoryId));
  }
}

function Items(): Item[] {
    return [{
    id: '1',
    name: 'item1',
    category: {
      id: '1',
      name: 'category1'
    }
  }, {
    id: '2',
    name: 'item2',
    category: {
      id: '2',
      name: 'Category 2'
    }
  },
  {
    id: '3',
    name: 'item3',
    category: {
      id: '2',
      name: 'Category 2'
    }
  }];
}

function Categories(): Category[] {
  return [{
    id: '1',
    name: 'Category 1'
  },
  {
    id: '2',
    name: 'Category 2'
  }];
}
