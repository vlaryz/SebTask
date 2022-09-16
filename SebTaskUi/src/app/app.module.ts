import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table';
import { AppComponent } from './app.component';
import { CustomersTableComponent } from './customers-table/customers-table.component';
import { MatSliderModule } from '@angular/material/slider';
import { HttpClientModule } from '@angular/common/http';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button'
import { CustomersListComponent } from './customers-list/customers-list.component';
import { AddCustomerDialogComponent } from './add-customer-dialog/add-customer-dialog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms'; 
import { MatInputModule } from '@angular/material/input';
import { PreviewCustomerDialogComponent } from './preview-customer-dialog/preview-customer-dialog.component';
import { MatFormFieldModule } from '@angular/material/form-field';


@NgModule({
  declarations: [
    AppComponent,
    CustomersTableComponent,
    CustomersListComponent,
    AddCustomerDialogComponent,
    PreviewCustomerDialogComponent
  ],
  imports: [
    BrowserModule,
    MatSliderModule,
    MatTableModule,
    HttpClientModule,
    MatDialogModule,
    MatButtonModule,
    BrowserAnimationsModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule
  ],
  entryComponents: [
    AddCustomerDialogComponent,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
