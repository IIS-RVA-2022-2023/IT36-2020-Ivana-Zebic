import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
    showMessageFlag: boolean = false;
    dialogMessage: string = 'Dobro dosli u aplikaciju za vodjenje evidencije o pacijentima u bolnici.';
  
    showDialog() {
      this.showMessageFlag = true;
    }
  
    closeDialog() {
      this.showMessageFlag = false;
    }
  }
