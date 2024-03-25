import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { JavaGirlzComponent } from './home/menu/java-girlz/java-girlz.component';
import { LoginComponent } from './home/menu/login/login.component';
import { MenuComponent } from './home/menu/menu.component';
import { EmployeepageComponent } from './employeepage/employeepage.component';
import { JobInterviewsComponent } from './job-interviews/job-interviews.component';


export const routes: Routes = [
    {path:"", component:HomeComponent},
    {path:'menu', component:MenuComponent},
    {path: 'javaGirlz', component:JavaGirlzComponent},
    {path: 'loginPage', component:LoginComponent},
    {path: 'jobInterviews', component:JobInterviewsComponent},
    {path: 'employeePage/:name/:surname', component:EmployeepageComponent},
]
