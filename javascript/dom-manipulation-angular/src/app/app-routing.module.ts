import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DomParentComponent } from './pages/dom-parent/dom-parent.component';
import { DomNeighborComponent } from './pages/dom-neighbor/dom-neighbor.component';

const routes: Routes = [{path: '', component: DomParentComponent},
                        {path: 'neighbor', component: DomNeighborComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
