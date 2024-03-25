import { Component, Input, OnInit, numberAttribute } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { CommonModule } from '@angular/common';
import { LoginserviceService } from '../services/loginservice.service';


@Component({
  selector: 'app-employeepage',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employeepage.component.html',
  styleUrl: './employeepage.component.css'
})
export class EmployeepageComponent implements OnInit  {

  
  employee: Employee = new Employee;
  name:string | null = null;
  surname:string | null = null;
  idEmployee!: number;
  
 

  constructor(private route: ActivatedRoute, private router: Router, private firstService: LoginserviceService,) {}
  
  ngOnInit(): void {
    this.name = this.route.snapshot.paramMap.get('name'); 
    this.surname = this.route.snapshot.paramMap.get('surname');// Ottieni il nome
    this.idEmployee = +(this.route.snapshot.paramMap.get('idEmployee')?? 0);
    }
  

    jobInterviews(idEmployee:number) {
      console.log('Calling jobInterviews with idEmployee:', idEmployee)
      this.router.navigate(['/jobInterviews', idEmployee]);
      this.firstService.getJobByIdEmployee(idEmployee).subscribe(data => {
          console.log('Interviews found...');
          console.log(this.jobInterviews);
          console.log(data);
        });
    }

  }
  







