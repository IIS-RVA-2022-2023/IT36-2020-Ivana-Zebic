import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { MatDialog } from "@angular/material/dialog";
import { MatTableDataSource } from "@angular/material/table";
import { Subscription } from "rxjs";
import { Dijagnoza } from "src/app/models/dijagnoza";
import { Odeljenje } from "src/app/models/odeljenje";
import { Pacijent } from "src/app/models/pacijent";
import { PacijentService } from "src/app/services/pacijent.service";
import { PacijentDialogComponent } from "../../dialogs/pacijent-dialog/pacijent-dialog.component";


@Component({
    selector: 'app-pacijent',
    templateUrl: './pacijent.component.html',
    styleUrls: ['./pacijent.component.css']
})

export class PacijentComponent implements OnChanges{
    dataSource!: MatTableDataSource<Pacijent>;
    displayedColumns = ['id', 'ime', 'prezime', 'zdr_osiguranje','datum_rodjenja','dijagnoza', 'actions'];
    subscription!: Subscription;

    @Input() childSelectedOdeljenje!: Odeljenje;

    constructor(
        private pacijentService: PacijentService,
        public dialog: MatDialog
    ) {}
    
    ngOnChanges(changes: SimpleChanges): void {
        if(this.childSelectedOdeljenje.id){
          this.loadData();
        }
      }
    ngOnDestroy(): void {
        this.subscription.unsubscribe();
    }
    ngOnInit(): void {
        this.loadData();
      }
      public loadData(){
        this.subscription = this.pacijentService.getPacijentByOdeljenje(this.childSelectedOdeljenje.id).subscribe(
          data => {this.dataSource = new MatTableDataSource(data);
                  console.log(data)}),
          (error:Error) => {console.log(error.name + ' ' + error.message);}
      }
    public openDialog(
        flag:number,
        id?:number,
        ime?:string,
        prezime?:string,
        zdr_osiguranje?:boolean,
        datum_rodjenja?: Date,
        dijagnoza?: Dijagnoza
    ):void {
        const dialogRef = this.dialog.open(PacijentDialogComponent, {data: {id,ime,prezime,zdr_osiguranje,datum_rodjenja,dijagnoza} 
        });
        dialogRef.componentInstance.flag = flag;
        if (flag == 1) {
            dialogRef.componentInstance.data.odeljenje = this.childSelectedOdeljenje;
        }
        dialogRef.afterClosed().subscribe( result => {
            if(result == 1){
                this.loadData();
            }
        });
    }
}