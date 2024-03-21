import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/Employee';

@Injectable({
  providedIn: 'root',
})

export class PrimoservizioService {

  constructor(private hC: HttpClient) { }

  getEmployeeById(id:number){
    return this.hC.get<Employee>('http://localhost:8080/Employee/ricercaByIdEmployee/'+ id);
  }
}
