import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatExpansionModule} from '@angular/material/expansion';
import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { AppComponent } from './app.component';
import { BolnicaComponent } from './components/main/bolnica/bolnica.component';
import { DijagnozaComponent } from './components/main/dijagnoza/dijagnoza.component';
import { BolnicaDialogComponent } from './components/dialogs/bolnica-dialog/bolnica-dialog.component';
import { DijagnozaDialogComponent } from './components/dialogs/dijagnoza-dialog/dijagnoza-dialog.component';
import { OdeljenjeComponent } from './components/main/odeljenje/odeljenje.component';
import { OdeljenjeDialogComponent } from './components/dialogs/odeljenje-dialog/odeljenje-dialog.component';
import { PacijentComponent } from './components/main/pacijent/pacijent.component';
import { PacijentDialogComponent } from './components/dialogs/pacijent-dialog/pacijent-dialog.component';
import { MatSortModule } from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import { HomeComponent } from './components/utility/home/home.component';
import { HomeDialogComponent } from './components/dialogs/home-dialog/home-dialog.component';
import { AuthorComponent } from './components/utility/author/author.component';
import { AboutComponent } from './components/utility/about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    BolnicaComponent,
    DijagnozaComponent,
    BolnicaDialogComponent,
    DijagnozaDialogComponent,
    OdeljenjeComponent,
    OdeljenjeDialogComponent,
    PacijentComponent,
    PacijentDialogComponent,
    HomeComponent,
    HomeDialogComponent,
    AuthorComponent,
    AboutComponent
    // dodati ostale komponente 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatGridListModule,
    MatExpansionModule,
    HttpClientModule,
    MatTableModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatSnackBarModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatCheckboxModule,
    MatSortModule,
    MatPaginatorModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
