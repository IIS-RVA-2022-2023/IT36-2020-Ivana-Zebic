import { Component } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { MatTableDataSource } from "@angular/material/table";
import { Subscription } from "rxjs";
import { Dijagnoza } from "src/app/models/dijagnoza";
import { DijagnozaService } from "src/app/services/dijagnoza.service";
import { DijagnozaDialogComponent } from "../../dialogs/dijagnoza-dialog/dijagnoza-dialog.component";

@Component({
    selector: 'app-dijagnoza',
    templateUrl: './dijagnoza.component.html',
    styleUrls: ['./dijagnoza.component.css'],
  })

  export class DijagnozaComponent {
    dataSource!: MatTableDataSource<Dijagnoza>;
    displayedColumns = ['id', 'naziv', 'opis', 'oznaka', 'actions'];
    subscription!: Subscription;

    constructor(
        private dijagnozaService: DijagnozaService,
        public dialog: MatDialog
    ) {}

    ngOnDestroy(): void {
        this.subscription.unsubscribe();
      }
    
    ngOnInit(): void {
        this.loadData();
      }
    loadData() {
       (this.subscription = this.dijagnozaService.getAllDijagnoza().subscribe((data) => {
        this.dataSource = new MatTableDataSource(data);
       })),
       (error:Error)=> {
        console.log(error.name + ' ' + error.message);
      };
    }
    public openDialog(
        flag:number,
        id?:number,
        naziv?:string,
        opis?:string,
        oznaka?:string
    ):void {
        const dialogRef = this.dialog.open(DijagnozaDialogComponent, {data: {id,naziv,opis,oznaka} 
        });
        dialogRef.componentInstance.flag = flag;
        dialogRef.afterClosed().subscribe((result) => {
            if(result == 1){
                this.loadData();
            }
        });
    }
  }