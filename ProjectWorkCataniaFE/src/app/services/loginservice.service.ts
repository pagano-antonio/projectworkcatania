import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { JobInterview } from '../model/JobInterview';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private hC: HttpClient) { }

getEmployeeByEmailAndPassword(email:string, password:string){
    return this.hC.get<Employee>('http://localhost:8080/EmployeeRest/searchByEmailAndPassword/'+ email + '/'+ password)
    .pipe(
      catchError(error => {
        console.log(error);
        return throwError('Something went wrong. Please try again.');
      })
    );
  }
  
getJobByIdEmployee(idEmployee:number){
  return this.hC.get<JobInterview[]>('http://localhost:8080/JobInterviewRest/searchByIdEmployee/'+ idEmployee);
}

}

