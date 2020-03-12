import { Directive, Renderer2, ElementRef, OnInit } from '@angular/core';

@Directive({
  selector: '[appAddClass]'
})
export class AddClassDirective implements OnInit{
  constructor(private renderer: Renderer2, private el: ElementRef ) { }
  public ngOnInit(): void {
    this.renderer.addClass(this.el.nativeElement, 'addedByRenderer');
  }
}