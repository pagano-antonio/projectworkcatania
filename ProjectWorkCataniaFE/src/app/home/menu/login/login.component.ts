import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from '../../../services/loginservice.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email!: string;
  password!: string;

  constructor(private router: Router, private firstService: LoginserviceService) {}

  login() {
    console.log('sto facendo login');
    this.firstService.getEmployeeByEmailAndPassword(this.email, this.password).subscribe;
    console.log('finito sono dentro');
  }
}