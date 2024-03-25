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


  
  constructor(private route: ActivatedRoute, private router: Router, private firstService: LoginserviceService,) {}
  
  ngOnInit(): void {
    this.name = this.route.snapshot.paramMap.get('name'); 
    this.surname = this.route.snapshot.paramMap.get('surname');// Ottieni il nome

    }


    jobInterviews(idEmployee:number){
      console.log('Sto cercando colloqui....');

      this.firstService.getJobByIdEmployee(idEmployee)
        .subscribe(data=> {
          console.log('Colloqui trovati...');
          console.log(this.jobInterviews);
          console.log(data);
          this.router.navigate(['/jobInterviews']);
        });


    }


  }
  







