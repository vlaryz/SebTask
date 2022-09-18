import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig } from '@angular/material/dialog';
import { AddCustomerDialogComponent } from '../add-customer-dialog/add-customer-dialog.component';
import { PreviewCustomerDialogComponent } from '../preview-customer-dialog/preview-customer-dialog.component';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {
  
  constructor(
    public dialogModel: MatDialog
  ) { }

  ngOnInit(): void {

  }

  openAddCustomerDialog() {
    this.dialogModel.open(AddCustomerDialogComponent,
      {
        width: '30%',
      });
  }
}
