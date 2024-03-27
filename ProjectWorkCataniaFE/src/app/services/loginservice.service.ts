import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { JobInterview } from '../model/JobInterview';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private hC: HttpClient) { }

getEmployeeByEmailAndPassword(email:string, password:string){
    return this.hC.get<Employee>('http://localhost:8080/EmployeeRest/searchByEmailAndPassword/'+ email + '/'+ password);
  }

getJobByIdEmployee(idEmployee:number){
  return this.hC.get<JobInterview[]>('http://localhost:8080/JobInterviewRest/searchByIdEmployee/'+ idEmployee);
}

}

<<<<<<< HEAD
// getEmployeeTypes(): Promise<EmployeeType[]> { con PROMISE
//   return this.hC.get<EmployeeType[]>('http://localhost:8080/EmployeeTypeRest/getAll').toPromise()
//     .then(employeeTypes => employeeTypes)
//     .catch(error => { console.log(error); return throwError('Something went wrong. Please try again.'); });
// }

postEmployee(employee: Employee): Observable<Employee> {
  return this.hC.post<Employee>('http://localhost:8080/EmployeeRest/addEmployee/', employee)
  .pipe(
    catchError(error => {
      console.log(error);
      return throwError('Something went wrong. Please try again.');
    })
  );
}
}


=======
>>>>>>> 555707c43ea8ff142b04dea17f72752d438098f2
