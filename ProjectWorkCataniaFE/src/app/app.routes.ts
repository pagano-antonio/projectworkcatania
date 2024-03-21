import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { JavaGirlzComponent } from './home/menu/java-girlz/java-girlz.component';
import { LoginComponent } from './home/menu/login/login.component';
import { MenuComponent } from './home/menu/menu.component';


export const routes: Routes = [
    {path:"", component:HomeComponent},
    {path:'menu', component:MenuComponent},
    {path: 'javaGirlz', component:JavaGirlzComponent},
    {path: 'loginPage', component:LoginComponent}
]
