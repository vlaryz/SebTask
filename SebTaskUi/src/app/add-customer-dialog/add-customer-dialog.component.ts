import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { catchError, EMPTY, map, NEVER, of } from 'rxjs';
import { CustomerRequest } from '../models/customer-request';
import { CustomerResponse } from '../models/customer-response';
import { CustomerService } from '../services/customer.service';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-add-customer-dialog',
  templateUrl: './add-customer-dialog.component.html',
  styleUrls: ['./add-customer-dialog.component.css']
})
export class AddCustomerDialogComponent implements OnInit {

  public errorMsg = "";
  public customer: CustomerResponse = {
    name: '',
    surname: '',
    birthDate: '',
    telNumber: '',
    email: ''
  };

  constructor(
    public dialogRef: MatDialogRef<AddCustomerDialogComponent>,
    private customerService: CustomerService
  ) { }

  ngOnInit(): void {
  }

  addCustomer() {
    this.errorMsg = "";
    console.log("cust: " + this.customer.email);
    // const request = {
    //   name: "aboba",
    //   surname: "surname",
    //   birthDate: "birthDate",
    //   telNumber: "+354546747",
    //   email: "fdgd@Gmfggd.com" 
    // } as CustomerRequest;

    this.customerService.createCustomer(this.customer).subscribe(
      response => {
        this.dialogRef.close();
      },
      error => {
        Object.entries(error.error).forEach((entry) => {
          const [key, value] = entry;
          this.errorMsg += (value+"<br>");
        });
      }
    )
  }

  close(): void {
    this.dialogRef.close();
  }

}
