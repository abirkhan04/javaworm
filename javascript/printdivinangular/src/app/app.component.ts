import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  public title = 'printdivinangular';
  public styles: string;

  constructor(private http: HttpClient) {}

  public ngOnInit(): void {
      this.http.get('assets/css/printeddiv.css', { responseType: 'text' }).subscribe((response) => {
        this.styles = response;
      });
  }

  public print(divName): void {
    let printContents: string;
    let popupWin: any;
    printContents = document.getElementById(divName).innerHTML;
    popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
    popupWin.document.open();
    popupWin.document.write(`
             <html>
               <head>
                 <title>Print Test div</title>
                 <style>${this.styles}</style>
               </head>
               <body onload="window.print();window.close()">${printContents}</body>
             </html>`
    );
    popupWin.document.close();
  }
}
