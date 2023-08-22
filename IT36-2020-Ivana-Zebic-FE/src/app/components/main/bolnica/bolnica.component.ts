import { Component, OnDestroy, OnInit, ViewChild  } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
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

    @ViewChild(MatSort, {static:false}) sort!:MatSort;
    @ViewChild(MatPaginator, {static:false}) paginator!:MatPaginator;

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
            data => {this.dataSource = new MatTableDataSource(data);
                this.dataSource.sort = this.sort;
                this.dataSource.paginator = this.paginator;}
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
    public applyFilter(filter:any){
        filter = filter.target.value;
        filter = filter.trim();
        filter = filter.toLocaleLowerCase();
        this.dataSource.filter = filter;
      }
}