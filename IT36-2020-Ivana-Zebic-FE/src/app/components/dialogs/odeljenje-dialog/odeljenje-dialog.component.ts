import { Component, Inject } from "@angular/core";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Bolnica } from "src/app/models/bolnica";
import { Odeljenje } from "src/app/models/odeljenje";
import { BolnicaService } from "src/app/services/bolnica.service";
import { OdeljenjeService } from "src/app/services/odeljenje.service";

@Component({
    selector: 'app-odeljenje-dialog',
    templateUrl: './odeljenje-dialog.component.html',
    styleUrls: ['./odeljenje-dialog.component.css'],
})

export class OdeljenjeDialogComponent {
    flag!: number;
    bolnice!: Bolnica[];

    constructor(
        public snackBar: MatSnackBar,
        public dialogRef: MatDialogRef<Odeljenje>,
        @Inject(MAT_DIALOG_DATA) public data: Odeljenje,
        public odeljenjeService : OdeljenjeService,
        public bolnicaService: BolnicaService
    ){}

    ngOnInit(): void {
      this.bolnicaService.getAllBolnica().subscribe(
        data => {
          this.bolnice = data;
        }
      )
    }
    public add(): void {
        this.odeljenjeService.addOdeljenje(this.data).subscribe(() => {
          this.snackBar.open(
            'Odeljenje sa nazivom: ' + this.data.naziv + ' je uspesno dodato!','Ok',{ duration: 4500 });
        }),
        (error: Error) => {
          console.log(error.name + ' ' + error.message);
          this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
          }
      }
      public update(): void {
        this.odeljenjeService.updateOdeljenje(this.data).subscribe(() => {
          this.snackBar.open(
            'Odeljenje sa ID: ' + this.data.id + ' je uspesno izmenjeno!','Ok', { duration: 4500 });
        }),
        (error: Error) => {
          console.log(error.name + ' ' + error.message);
          this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
          }
      }
      public delete(): void {
        this.odeljenjeService.deleteOdeljenje(this.data.id).subscribe(() => {
          this.snackBar.open('Odeljenje je izbrisano!', 'Ok', { duration: 4500 });
        }),
        (error: Error) => {
          console.log(error.name + ' ' + error.message);
          this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
          }
      }
      public cancel(): void {
        this.dialogRef.close();
        this.snackBar.open('Odustali ste od izmena', 'Ok', { duration: 2500 });
      }
      public compare(a:any, b:any){
        return a.id == b.id;
      }
}