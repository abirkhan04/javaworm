import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appErrorDirective]'
})
export class ErrorDirective {

  constructor(elementRef: ElementRef) {
    elementRef.nativeElement.style.background = 'red';
  }

}
