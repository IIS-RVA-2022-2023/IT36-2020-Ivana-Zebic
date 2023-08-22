import { Component } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { MatTableDataSource } from "@angular/material/table";
import { Subscription } from "rxjs";
import { Odeljenje } from "src/app/models/odeljenje";
import { OdeljenjeService } from "src/app/services/odeljenje.service";
import { OdeljenjeDialogComponent } from "../../dialogs/odeljenje-dialog/odeljenje-dialog.component";
import { Bolnica } from "src/app/models/bolnica";

@Component({
    selector: 'app-odeljenje',
    templateUrl: './odeljenje.component.html',
    styleUrls: ['./odeljenje.component.css']
})

export class OdeljenjeComponent {
    dataSource!: MatTableDataSource<Odeljenje>;
    displayedColumns = ['id', 'naziv', 'lokacija', 'bolnica', 'actions'];
    subscription!:Subscription;

    parentSelectedOdeljenje!:Odeljenje;

    constructor(
        private odeljenjService: OdeljenjeService,
        public dialog: MatDialog
    ) {}

    ngOnDestroy(): void {
        this.subscription.unsubscribe();
    }
    ngOnInit(): void {
        this.loadData();
      }
    loadData(){
        this.subscription = this.odeljenjService.getAllOdeljenje().subscribe(data => {
            this.dataSource = new MatTableDataSource(data);
            console.log(data)}),
           (error:Error)=> {
            console.log(error.name + ' ' + error.message);
          }
    }
    public openDialog(
        flag:number,
        id?:number,
        naziv?:string,
        lokacija?:string,
        bolnica?:Bolnica 
    ):void {
        const dialogRef = this.dialog.open(OdeljenjeDialogComponent, {data: {id,naziv,lokacija,bolnica} 
        });
        dialogRef.componentInstance.flag = flag;
        dialogRef.afterClosed().subscribe( result => {
            if(result == 1){
                this.loadData();
            }
        })
    }
    public selectRow(row:Odeljenje):void{
        this.parentSelectedOdeljenje = row;
        console.log(row);
      }
}