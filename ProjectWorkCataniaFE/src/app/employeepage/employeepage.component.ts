import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { CommonModule } from '@angular/common';


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


  
  constructor(private route: ActivatedRoute, private router: Router) {}
  
  ngOnInit(): void {
    this.name = this.route.snapshot.paramMap.get('name'); 
    this.surname = this.route.snapshot.paramMap.get('surname');// Ottieni il nome
    
    }
  }
  

 /* ngOnInit(): void {
    
  console.log(this.route.snapshot.data['employee']);
  this.employee = this.route.snapshot.data['employee'];
  
}*/





