import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
<<<<<<< HEAD
<<<<<<< HEAD
import { ToastrModule } from 'ngx-toastr';
=======
import { NgIf } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
>>>>>>> parent of b80f3fc (finita anche la parte della sign up e funziona con tutti gli errori)

=======
import { NgIf } from '@angular/common'; 
>>>>>>> 555707c43ea8ff142b04dea17f72752d438098f2

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideClientHydration(),
    provideHttpClient(),
  ],
};