import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
<<<<<<< HEAD
import { ToastrModule } from 'ngx-toastr';

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