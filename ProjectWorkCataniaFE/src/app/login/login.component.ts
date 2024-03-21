import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';
import { LoginserviceService } from '../services/loginservice.service';

@Component({
  selector: 'app-binding',
  standalone: true,
  imports: [FormsModule, RouterOutlet],
  templateUrl: './binding.component.html',
  styleUrl: './binding.component.css'
})
export class BindingComponent {
user:String = '';
pwd:String = '';
loginMessage:String = '';
loginStatus:boolean = false;

constructor(private router: Router, private firstService: LoginserviceService) {} //QUESTO È IMPORTANTE PER IL SERVICE

prova(){
  if(this.user === 'root' && this.pwd === '1234'){
    this.loginStatus = true;
    //window.location.href = '/welcome';
    this.router.navigate(['/welcome', this.user]);
  } else {
    this.loginStatus = false;
    //this.loginMessage = 'Login Failed';
    this.router.navigate(['/loginfail', this.user]);
  }
}

//METODO TEST SERVICE - CREARE BUTTON NELL'HTML
//SU ECLIPSE AGGIUNGERE L'ANNOTATION @CrossOrigin NELLA CLASSE REST INTERESSATA, EMPLOYEEREST ED 

login(){
  this.firstService.getEmployeeById(1).subscribe(data => {
    console.log(data);
  });
  console.log('ciao');
}
}
