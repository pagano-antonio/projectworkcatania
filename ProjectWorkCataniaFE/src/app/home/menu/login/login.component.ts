import { Component, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from '../../../services/loginservice.service';
import { FormsModule } from '@angular/forms';
import { Employee } from '../../../model/employee';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation:  ViewEncapsulation.None // disabilita incapsulamento della vista
})
export class LoginComponent {
  email: string= '';
  password: string = '';
  name: string = '';
  surname: string = '';
  employee: Employee = new Employee;
  errorMessage: string = '';
  

  constructor(private router: Router, private firstService: LoginserviceService, ) {
  }


  login() {
    if (this.email && this.password) {
      this.firstService.getEmployeeByEmailAndPassword(this.email, this.password)
        .subscribe( data => {
            console.log('Login successful');
            console.log(this.employee);
            console.log(data);
            this.router.navigate(['/employeePage', data.name, data.surname, data.idEmployee]);
          },
          error => {
            console.log('Error:', error);
            this.errorMessage = 'Wrong email or password! Please try again.';
          }
        );
    } else {
      this.errorMessage = 'Please enter your email and password.';
    }
  }
  
}