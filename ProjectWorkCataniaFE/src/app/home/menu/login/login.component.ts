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
  user: String = '';
  pwd: String = '';
  loginMessage: String = '';
  loginStatus: boolean = false;

  constructor(private router: Router, private firstService: LoginserviceService) {}

  login() {
    this.firstService.getEmployeeByEmailAndPassword();
    console.log('ciao');
  }
}