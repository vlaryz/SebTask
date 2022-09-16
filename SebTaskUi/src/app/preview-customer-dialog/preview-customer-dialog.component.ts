import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CustomerResponse } from '../models/customer-response';

@Component({
  selector: 'app-preview-customer-dialog',
  templateUrl: './preview-customer-dialog.component.html',
  styleUrls: ['./preview-customer-dialog.component.css']
})
export class PreviewCustomerDialogComponent implements OnInit {

  public tableData: CustomerResponse[] = [];
  public displayedColumns: string[] = ['name', 'surname', 'birthDate', 'telNumber', 'email'];

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: CustomerResponse
  ) { 
    this.tableData[0] = data;
  }

  ngOnInit(): void {
  }
}
