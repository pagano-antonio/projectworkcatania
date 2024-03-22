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
export class EmployeepageComponent  implements OnInit  {
[x: string]: any;
  
  
  employee: Employee = new Employee;

  
  constructor(private route: ActivatedRoute, private router: Router) {}
  
  /*ngOnInit(): void {
    this.route.data.subscribe((data: { employee: Employee }) => {
      console.log(data.employee);
      this.employee = data.employee;
    });
  }*/
  

  ngOnInit(): void {
    
  console.log(this.route.snapshot.data['employee']);
  this.employee = this.route.snapshot.data['employee'];
  

}
}
