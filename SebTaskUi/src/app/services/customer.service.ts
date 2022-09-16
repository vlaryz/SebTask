import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerResponse } from '../models/customer-response';
import { CustomerRequest } from '../models/customer-request';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(
    private readonly httpService: HttpService
  ) { }

  public getCustomers(): Observable<CustomerResponse[]> {
    return this.httpService.get('/api/customers/v1', '/listCustomers');
  }

  public createCustomer(customerCreate: CustomerRequest): Observable<any> {
    return this.httpService.post('/api/customers/v1', '/addCustomer', customerCreate);
  }
}
