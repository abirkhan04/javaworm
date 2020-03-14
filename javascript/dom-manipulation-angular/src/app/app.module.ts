import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DomParentComponent } from './pages/dom-parent/dom-parent.component';
import { DomNeighborComponent } from './pages/dom-neighbor/dom-neighbor.component';
import { AddClassDirective } from './directives/add-class.directive';
import { TestComponent } from './pages/test/test.component';
import { TestInvokerComponent } from './pages/test-invoker/test-invoker.component';

@NgModule({
  declarations: [
    AppComponent,
    DomParentComponent,
    DomNeighborComponent,
    AddClassDirective,
    TestComponent,
    TestInvokerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
