import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeType } from '../../model/EmployeeType';
import { LoginserviceService } from '../../services/loginservice.service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl:'./sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {

  employeeType = new EmployeeType;
  description:string | null = null;
  employeeTypes$: Observable<any> 
  
  constructor(private route: ActivatedRoute, private router: Router, private firstService: LoginserviceService) {
    this.employeeTypes$ = this.firstService.getEmployeeTypes();
  }

  ngOnInit(): void {
    this.description = this.route.snapshot.paramMap.get('description'); 
    
    }
  
  signUpEmployee(){


  }

}
