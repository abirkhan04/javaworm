import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DomParentComponent } from './pages/dom-parent/dom-parent.component';
import { DomNeighborComponent } from './pages/dom-neighbor/dom-neighbor.component';
import { AddClassDirective } from './directives/add-class.directive';

@NgModule({
  declarations: [
    AppComponent,
    DomParentComponent,
    DomNeighborComponent,
    AddClassDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
