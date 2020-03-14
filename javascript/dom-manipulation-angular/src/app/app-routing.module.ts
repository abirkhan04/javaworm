import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DomParentComponent } from './pages/dom-parent/dom-parent.component';
import { DomNeighborComponent } from './pages/dom-neighbor/dom-neighbor.component';
import { TestComponent } from './pages/test/test.component';
import { TestInvokerComponent } from './pages/test-invoker/test-invoker.component';

const routes: Routes = [{path: '', component: DomParentComponent},
                        {path: 'neighbour', component: DomNeighborComponent},
                        {path: 'test-content-projection', component: TestInvokerComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
