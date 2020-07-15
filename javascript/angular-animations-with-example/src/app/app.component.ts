import { Component } from '@angular/core';
import {
  trigger,
  style,
  animate,
  transition,
  query,
  stagger,
  keyframes,
  state
} from '@angular/animations';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  animations: [
    trigger('ThrowACard', [state('onHand', style(
      {
        position: 'relative',
        top: 0,
        left: '500px',
        background: '#E0E0E0',
      })
    ),
    state('thrown', style(
      {
        position: 'relative',
        top: '300px',
        left: '800px',
        background: '#004E41',
        color: 'white',
        opacity: 1,
      }
    )),
    transition('onHand => thrown', [style({opacity: 0}), animate(1000)]),
    transition('thrown => onHand', animate(1000)),
    ],
    ),
    trigger('InsertRemoveTrigger', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('500ms', style({ opacity: 1 })),
      ]),
      transition(':leave', [
        animate('500ms', style({ opacity: 0 }))
      ])
    ]),
    trigger('CardStagger',
      [transition('void => *', [
        query(':enter', style({ opacity: 0 }), { optional: true }),
        query(':enter', [stagger('300ms', animate('0.5s ease-in', keyframes([
          style({ opacity: 0, transform: 'translateX(-50%)', offset: 0 }),
          style({ opacity: 0.5, transform: 'translateX(-10px) scale(1.3)', offset: 0.3 }),
          style({ opacity: 1, transform: 'translateX(0)', offset: 1 }),
        ])))
        ], { optional: true }),
      ]),
      transition('* => void', [
        query(':leave', animate('2s ease-out', keyframes([
          style({ opacity: 0.8 }),
          style({ opacity: 0.4 }),
          style({ opacity: 0 })
        ])))
      ]),
      ],
    )],
})
export class AppComponent {
  public isShown: boolean = false;
  public cardVisible: boolean = true;
  public isThrown: boolean = false;
  public cardLength: number = 2;
  public cards: number[] = Array(4).fill(0).reduce(arr => { arr.push(arr.length); return arr; }, []);

  public toggleBox(): void {
    this.isShown = !this.isShown;
  }

  public toggleCards(): void {
    this.cardVisible = !this.cardVisible;
  }

  public throwACard(): void {
    this.isThrown = !this.isThrown;
  }

}
