import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent {
  constructor(private router: Router) {}

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
    this.router.navigate(['/signUpPage']);
  }

}