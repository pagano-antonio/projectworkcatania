import { Component, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeType } from '../../model/EmployeeType';
import { LoginserviceService } from '../../services/loginservice.service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { Employee } from '../../model/employee';


@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl:'./sign-up.component.html',
  styleUrl: './sign-up.component.css',
  encapsulation:  ViewEncapsulation.None
})
export class SignUpComponent {

  employeeType = new EmployeeType;
  description:string | null = null;
  employeeTypes$: Observable<any> 
  employee: Employee=new Employee();
  errorMessage: string = '';
  
  
  constructor(private route: ActivatedRoute, private router: Router, private firstService: LoginserviceService) {
    this.employeeTypes$ = this.firstService.getEmployeeTypes();
  }

  ngOnInit(): void {
    this.description = this.route.snapshot.paramMap.get('description'); 
    }
  
    signUpEmployee(){
      console.log('Adding an Employee');
      console.log(this.employeeType);
      this.employee.employeeType =  this.employeeType;
      console.log(this.employee);
      this.firstService.postEmployee(this.employee)
      .subscribe(
        (response: Employee) => {
          console.log(this.employee);
          alert("Employee added successfully");
          this.router.navigate(['/loginPage']);
        },
        (error) => {
          console.log(error);
            alert("Email already used! Please try login or change email.");
          } 
      );
    };
  
    
}
