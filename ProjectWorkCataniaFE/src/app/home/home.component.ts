import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginserviceService } from '../services/loginservice.service';
import { EmployeeType } from '../model/EmployeeType';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})


export class HomeComponent {

  
  constructor(private route: ActivatedRoute, private router: Router, private firstService: LoginserviceService) {}


  homePage(){
    this.router.navigate(['']);
  }

  javaGirlz(){
    this.router.navigate(['/javaGirlz']);
  }

  loginPage(){
    this.router.navigate(['/loginPage']);
  }
  
  signUpPage(){

    this.router.navigate(['/signUp']);
  }

}