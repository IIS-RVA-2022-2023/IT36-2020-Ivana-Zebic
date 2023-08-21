import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-home-dialog',
  templateUrl: './home-dialog.component.html',
  styleUrls: ['./home-dialog.component.css']
})
export class HomeDialogComponent {
  @Input() message: string = '';
  @Output() dialogClosed = new EventEmitter<void>();

  closeDialog() {
    this.dialogClosed.emit();
  }
}
