import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
    selector: 'app-about',
    templateUrl: './about.component.html',
    styleUrls: ['./about.component.css']
  })

export class AboutComponent {

  constructor(
    public snackBar: MatSnackBar
  ) {}
  showMessage() {
    this.snackBar.open(
      'Aktivnosti vodjenja evidencije u Bolnici nalaze se s leve strane u prvom padajucem meniju',
      'Ok',
      { duration: 4500 }
    );
  }

}