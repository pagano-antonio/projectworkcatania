import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { JobInterview } from '../model/JobInterview';
import { Observable, catchError, throwError } from 'rxjs';
import { EmployeeType } from '../model/EmployeeType';

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

getEmployeeTypes(): Observable<EmployeeType[]> { // Aggiungi questo metodo
  return this.hC.get<EmployeeType[]>('http://localhost:8080/EmployeeTypeRest/preSignUp') // Aggiungi questo endpoint
  .pipe( catchError(error => { console.log(error); return throwError('Something went wrong. Please try again.'); }) );
}

// getEmployeeTypes(): Promise<EmployeeType[]> { con PROMISE
//   return this.hC.get<EmployeeType[]>('http://localhost:8080/EmployeeTypeRest/getAll').toPromise()
//     .then(employeeTypes => employeeTypes)
//     .catch(error => { console.log(error); return throwError('Something went wrong. Please try again.'); });
// }

// saveEmployee(){
//    return this.hC.post<Employee>('http://localhost:8080/EmployeeRest/addEmployee);


// }
}

