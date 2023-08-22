import { Component, Inject } from "@angular/core";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Dijagnoza } from "src/app/models/dijagnoza";
import { Pacijent } from "src/app/models/pacijent";
import { DijagnozaService } from "src/app/services/dijagnoza.service";
import { PacijentService } from "src/app/services/pacijent.service";

@Component({
    selector: 'app-pacijent-dialog',
    templateUrl:'./pacijent-dialog.component.html',
    styleUrls: ['./pacijent-dialog.component.css'],
})

export class PacijentDialogComponent {
    flag!: number;
    dijagnoze!: Dijagnoza[];

    constructor(
        public snackBar: MatSnackBar,
        public dialogRef: MatDialogRef<Pacijent>,
        @Inject(MAT_DIALOG_DATA) public data: Pacijent,
        public pacijentService : PacijentService,
        public dijagnozaService:DijagnozaService
    ){}
    ngOnInit(): void {
      this.dijagnozaService.getAllDijagnoza().subscribe(
        data => {
          this.dijagnoze = data;
        }
      )
    }
    public add(): void {
        this.pacijentService.addPacijent(this.data).subscribe(() => {
          this.snackBar.open(
            'Pacijent : ' + this.data.ime +' '+ this.data.prezime +' je uspesno dodat/a!',
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
        this.pacijentService.updatePacijent(this.data).subscribe(() => {
          this.snackBar.open(
            'Pacijent sa ID: ' + this.data.id + ' je uspesno izmenjen!',
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
        this.pacijentService.deletePacijent(this.data.id).subscribe(() => {
          this.snackBar.open('Pacijent je izbrisan!', 'Ok', { duration: 4500 });
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
      public compare(a:any, b:any){
        return a.id == b.id;
      }
}