import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DomParentComponent } from './pages/dom-parent/dom-parent.component';
import { DomNeighborComponent } from './pages/dom-neighbor/dom-neighbor.component';
import { TestInvokerComponent } from './pages/test-invoker/test-invoker.component';
import { RenderHtmlUsingRenderer2Component } from './pages/render-html-using-rendered2/render-html-using-renderer2.component';

const routes: Routes = [{path: '', component: DomParentComponent},
                        {path: 'neighbour', component: DomNeighborComponent},
                        {path: 'test-content-projection', component: TestInvokerComponent},
                        {path: 'render-html-using-renderer2', component: RenderHtmlUsingRenderer2Component}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
