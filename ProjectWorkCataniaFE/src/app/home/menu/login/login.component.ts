import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from '../../../services/loginservice.service';
import { FormsModule } from '@angular/forms';
import { Employee } from '../../../model/employee';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string= '';
  password: string = '';
  name: string = '';
  surname: string = '';
  employee: Employee = new Employee;

  


  constructor(private router: Router, private firstService: LoginserviceService, ) {}
  
  login() {
    console.log('I am login in...');

    this.firstService.getEmployeeByEmailAndPassword(this.email, this.password)
      .subscribe(data=> {
        console.log('Login successful');
        console.log(this.employee);
        console.log(data);
        this.router.navigate(['/employeePage', data.name, data.surname, data.idEmployee]);
      });
  }

}
