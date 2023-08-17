import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BolnicaComponent } from './components/main/bolnica/bolnica.component';
import { DijagnozaComponent } from './components/main/dijagnoza/dijagnoza.component';
import { OdeljenjeComponent } from './components/main/odeljenje/odeljenje.component';
import { PacijentComponent } from './components/main/pacijent/pacijent.component';

const routes: Routes = [
  {path: 'bolnica' , component: BolnicaComponent},
  {path: 'odeljenje' , component: OdeljenjeComponent},
  {path: 'pacijent' , component: PacijentComponent},
  {path: 'dijagnoza' , component: DijagnozaComponent},
  //{path: 'home' , component:},
  //{path: 'author' , component:},
  //{path: 'about' , component:},
  {path: '' , redirectTo:'/home', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
