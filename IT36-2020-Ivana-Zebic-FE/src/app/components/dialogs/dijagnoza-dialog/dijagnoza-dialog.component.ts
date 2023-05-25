import { Component, Inject } from "@angular/core";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Dijagnoza } from "src/app/models/dijagnoza";
import { DijagnozaService } from "src/app/services/dijagnoza.service";

@Component({
    selector: 'app-dijagnoza-dialog',
    templateUrl: './dijagnoza-dialog.component.html',
    styleUrls: ['./dijagnoza-dialog.component.css'],
})

export class DijagnozaDialogComponent {
    flag!: number;

    constructor(
        public snackBar: MatSnackBar,
        public dialogRef: MatDialogRef<Dijagnoza>,
        @Inject(MAT_DIALOG_DATA) public data: Dijagnoza,
        public dijagnozaService : DijagnozaService
    ){}
    
    public add(): void {
        this.dijagnozaService.addDijagnoza(this.data).subscribe(() => {
          this.snackBar.open(
            'Dijagnoza sa nazivom: ' + this.data.naziv + ' je uspesno dodata!',
            'Ok',
            { duration: 4500 }
          );
        }),
          (error: Error) => {
            console.log(error.name + ' ' + error.message);
            this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
          };
      }
    
      public update(): void {
        this.dijagnozaService.updateDijagnoza(this.data).subscribe(() => {
          this.snackBar.open(
            'Dijagnoza sa ID: ' + this.data.id + ' je uspesno izmenjena!',
            'Ok',
            { duration: 4500 }
          );
        }),
          (error: Error) => {
            console.log(error.name + ' ' + error.message);
            this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
          };
      }
    
      public delete(): void {
        this.dijagnozaService.deleteDijagnoza(this.data.id).subscribe(() => {
          this.snackBar.open('Dijagnoza je izbrisana!', 'Ok', { duration: 4500 });
        }),
          (error: Error) => {
            console.log(error.name + ' ' + error.message);
            this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
          };
      }
    
      public cancel(): void {
        this.dialogRef.close();
        this.snackBar.open('Odustali ste od izmena', 'Ok', { duration: 2500 });
      }

}