import { Component, Inject } from "@angular/core";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Bolnica } from "src/app/models/bolnica";
import { BolnicaService } from "src/app/services/bolnica.service";

@Component({
    selector: 'app-bolnica-dialog',
    templateUrl: './bolnica-dialog.component.html',
    styleUrls: ['./bolnica-dialog.component.css']
  })

  export class BolnicaDialogComponent{

    flag!:number;

    constructor(public snackBar:MatSnackBar,
        public dialogRef: MatDialogRef<Bolnica>,
        @Inject(MAT_DIALOG_DATA) public data: Bolnica,
        public bolnicaService:BolnicaService){}

    public add():void {
        this.bolnicaService.addBolnica(this.data).subscribe(
            () => { 
                this.snackBar.open('Bolnica sa nazivom ' + this.data.naziv + ' je uspesno dodata!')
            }
        ),
        (error:Error) => {
            console.log(error.name + ' ' + error.message);
            this.snackBar.open('Dogodila se greska','Ok',{duration:2500});
        }
    }

    public update():void {
        this.bolnicaService.updateBolnica(this.data).subscribe(
            () => {
                this.snackBar.open('Bolnica sa ID: ' + this.data.id + 'je uspesno izmenjen!', 'Ok', {duration:4000});
            }
        ),
        (error:Error) => {
            console.log(error.name + ' '+ error.message);
            this.snackBar.open('Dogodila se greska','Ok',{duration:2500});
        }
    }

    public delete():void {
        this.bolnicaService.deleteBolnica(this.data.id).subscribe(
            () => {
                this.snackBar.open('Bolnica sa ID: ' + this.data.id + 'je izbrisana!', 'Ok',{duration:4500});
            }
        ),
        (error:Error) => {
            console.log(error.name + ' ' + error.message);
            this.snackBar.open('Dogodila se greska','Ok',{duration:2500})
        }
    }

    public cancel():void{
        this.dialogRef.close();
        this.snackBar.open('Odustali ste od izmena','Ok', {duration:2500});
    }
  }