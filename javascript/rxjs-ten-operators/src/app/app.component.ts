import { Component, OnInit } from '@angular/core';
import { AppService } from './service/app.service';
import { Category, Item } from './app-interfaces';
import { mergeMap, delay, map, switchAll,
    switchMap, concatMap, withLatestFrom , take, pluck, filter, scan, takeUntil } from 'rxjs/operators';
import { Observable, of, from, interval } from 'rxjs';

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
    this.checkSwitchMap();
    this.checkConcatMap();
    this.checkTake();
    this.checkPluck();
    this.checkTakeUntil();
  }

  public checkSwitchMap(): void {
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

  public checkConcatMap(): void {
    from([1, 2, 3, 4]).pipe(
      map(param => this.getData(param))
    ).subscribe(val => val.subscribe(data => console.log('map:', data)));


    from([1, 2, 3 , 4]).pipe(
      mergeMap(param => this.getData(param))
    ).subscribe(val => console.log('mergeMap:', val));

    from([1, 2, 3 , 4]).pipe(
      concatMap(param => this.getData(param))
    ).subscribe(val => console.log('concatMap:', val));
  }

  public checkTake(): void {
    from([1, 2, 3, 4]).pipe(mergeMap(
      param => this.getData(param))).pipe(take(3)).subscribe( val => console.log('take:', val));
  }

  public checkPluck(): void {
    this.appService.getItemFromItems().pipe(pluck('name')).subscribe((item) =>{
        console.log('name only here -->', item);
    });
  }

  public checkTakeUntil(): void {
    const numberSource = interval(1000);
    const isEven = val => val % 2 === 0;
    const evenSource = numberSource.pipe(filter(isEven));
    const countofEvenNumber = evenSource.pipe(scan((acc, _) => acc + 1, 0));
    const fiveEvenNumbers = countofEvenNumber.pipe(filter(val => val > 5));
    const exampleEvent = evenSource.pipe(
       withLatestFrom(countofEvenNumber), map(([val, count]) => `Even number (${count}) : ${val}`), takeUntil(fiveEvenNumbers));
    exampleEvent.subscribe((val) => console.log('Take Until test -->', val));
  }
}
