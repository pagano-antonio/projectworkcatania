import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private hC: HttpClient) { }

  getEmployeeByEmailAndPassword(email:string, password:string){
    return this.hC.get<Employee>('http://localhost:8080/EmployeeRest/searchByEmailAndPassword/'+ email + '/'+ password);
  }
}
