import { Component, ViewChild, OnInit, ElementRef, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-render-html-using-renderer2',
  templateUrl: './render-html-using-renderer2.component.html',
  styleUrls: ['./render-html-using-renderer2.component.scss']
})
export class RenderHtmlUsingRenderer2Component implements OnInit {

  constructor(private renderer: Renderer2) { }
  @ViewChild('container', {static : true}) private container: ElementRef;
  private template: string = `<p>Test Paragrahp</p><br><div>Test div</div>`;

   public ngOnInit(): void {
       this.renderer.setProperty(this.container.nativeElement, 'innerHTML', this.template );
   }

}
