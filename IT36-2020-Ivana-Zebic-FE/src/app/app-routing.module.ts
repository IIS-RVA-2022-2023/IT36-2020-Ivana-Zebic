import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BolnicaComponent } from './components/main/bolnica/bolnica.component';
import { DijagnozaComponent } from './components/main/dijagnoza/dijagnoza.component';

const routes: Routes = [
  {path: 'bolnica' , component: BolnicaComponent},
  {path: 'odeljenje' , component: },
  {path: 'pacijent' , component:},
  {path: 'dijagnoza' , component:DijagnozaComponent},
  {path: 'home' , component:},
  {path: 'author' , component:},
  {path: 'about' , component:},
  {path: '' , redirectTo:'/home', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
