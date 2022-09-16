import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { CustomerResponse } from '../models/customer-response';
import { PreviewCustomerDialogComponent } from '../preview-customer-dialog/preview-customer-dialog.component';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-customers-table',
  templateUrl: './customers-table.component.html',
  styleUrls: ['./customers-table.component.css']
})
export class CustomersTableComponent implements OnInit {

  public displayedColumns: string[] = ['name', 'surname', 'birthDate', 'preview'];
  public customers = new MatTableDataSource<CustomerResponse>();

  constructor(
    private customerService: CustomerService,
    public dialogModel: MatDialog
  ) { }

  ngOnInit(): void {
    this.initializeCustomers();
  }

  private initializeCustomers(): void {
    this.customerService.getCustomers().subscribe(
      customers => this.customers.data = customers
    );
  }
  
  openCustomerPreviewDialog(row: CustomerResponse) {
    this.dialogModel.open(PreviewCustomerDialogComponent,
      { 
        data: row,
        width: '50%'
      });
  }

  public doFilter = (value: string) => {
    this.customers.filter = value.trim().toLocaleLowerCase();
  }
}
