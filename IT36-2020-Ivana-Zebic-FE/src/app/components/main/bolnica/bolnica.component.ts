import { Component, OnDestroy, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { MatTableDataSource } from "@angular/material/table";
import { Subscription } from "rxjs";
import { Bolnica } from "src/app/models/bolnica";
import { BolnicaService } from "src/app/services/bolnica.service";
import { BolnicaDialogComponent } from "../../dialogs/bolnica-dialog/bolnica-dialog.component";

@Component({
    selector:'app-bolnica',
    templateUrl: './bolnica.component.html',
    styleUrls: ['./bolnica.component.css']
})

export class BolnicaComponent implements OnInit,OnDestroy{
    dataSource!: MatTableDataSource<Bolnica>;
    displayedColumns = ['id','naziv','adresa','budzet', 'actions'];
    subscription!:Subscription;

    constructor(private bolnicaService: BolnicaService,
                public dialog: MatDialog) {}

    ngOnDestroy(): void {
        this.subscription.unsubscribe();
    }
    ngOnInit(): void {
        this.loadData();
    }
    public loadData() {
        this.subscription = this.bolnicaService.getAllBolnica().subscribe(
            data => {this.dataSource = new MatTableDataSource(data);}
        ),
        (error:Error) => {console.log(error.name + ' ' + error.message);}
    }
    public openDialog(flag:number, id?:number, naziv?:string, adresa?:string, budzet?:number):void{
        const dialogRef = this.dialog.open(BolnicaDialogComponent, {data: {id,naziv,adresa,budzet}});
        dialogRef.componentInstance.flag = flag;
        dialogRef.afterClosed().subscribe(
            result => {
                if (result == 1){
                    this.loadData();
                }
            }
        )
    }
}