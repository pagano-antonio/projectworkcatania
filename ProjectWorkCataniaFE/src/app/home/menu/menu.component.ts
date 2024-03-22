import { Component } from '@angular/core';
import { HomeComponent } from '../home.component';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent extends HomeComponent{

}
