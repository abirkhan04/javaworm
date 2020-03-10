import { Component, OnInit } from '@angular/core';
import { AppService } from './service/app.service';
import { Category, Item } from './app-interfaces';
import { mergeMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  public categories: |Array<Category>;
  public items: Array<Item>;
  public items$: Observable<Item[]>;
  public categoryId: string = '2';

  constructor(private appService: AppService) {
  }

  public ngOnInit(): void {
    this.items$ =  this.appService.getCategoryById(
        this.categoryId).pipe(mergeMap(category => this.appService.getItemByCategory(category.id)));
  }

}
