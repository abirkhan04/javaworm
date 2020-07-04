import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {

  public title: string = 'testString';

  public ngOnInit(): void {
      const titleArray = [...this.title].entries();
      for (let title of titleArray ) {
            console.log(title);
      }

      const titleArrayIterator = this.title[Symbol.iterator]();
      console.log(titleArrayIterator.next());
  }

}
