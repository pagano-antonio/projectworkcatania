import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../services/loginservice.service';
import { JobInterview } from '../model/JobInterview';

@Component({
  selector: 'app-job-interviews',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './job-interviews.component.html',
  styleUrl: './job-interviews.component.css'
})
export class JobInterviewsComponent {


  jobInterviewFound:JobInterview[]=[] ;
  idEmployee!: number;

constructor(private route: ActivatedRoute, private firstService: LoginserviceService,) {}


 ngOnInit() {
  this.idEmployee = +(this.route.snapshot.paramMap.get('idEmployee')?? 0);
  this.firstService.getJobByIdEmployee(this.idEmployee).subscribe(data => {
    console.log('Interviews found...');
    console.log(data);
    this.jobInterviewFound = data;
  });

 }

}
