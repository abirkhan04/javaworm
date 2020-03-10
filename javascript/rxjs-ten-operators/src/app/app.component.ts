import { Component, OnInit } from '@angular/core';
import { AppService } from './service/app.service';
import { Category, Item } from './app-interfaces';
import { mergeMap, delay, map, switchAll, switchMap } from 'rxjs/operators';
import { Observable, of, from } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  public categories: | Array<Category>;
  public items: Array<Item>;
  public items$: Observable<Item[]>;
  public categoryId: string = '2';

  private getData = (param) => {
    return of(`Data with param ${param}`).pipe(
      delay(1000)
    );
  }

  constructor(private appService: AppService) {
  }

  public ngOnInit(): void {
    this.items$ = this.appService.getCategoryById(
      this.categoryId).pipe(mergeMap(category => this.appService.getItemByCategory(category.id)));
    this.checkSwitchAll();
  }

  public checkSwitchAll(): void {
    from([1, 2, 3, 4]).pipe(
      map(param => this.getData(param))).subscribe(val => val.subscribe(data => console.log(data)));

    from([1, 2, 3, 4]).pipe(
      map(param => this.getData(param)),
      switchAll()
    ).subscribe(val => console.log(val));

    from([1, 2, 3, 4]).pipe(
      switchMap(param => this.getData(param))
    ).subscribe(val => console.log(val));
  }
}
