import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CabeceraComponent } from './componentes/cabecera/cabecera.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { LandingComponent } from './componentes/landing/landing.component';
import { LoginComponent } from './componentes/login/login.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { VideojuegoComponent } from './componentes/videojuego/videojuego.component';
import { VideojuegosComponent } from './componentes/videojuegos/videojuegos.component';
import { DetalleComponent } from './componentes/detalle/detalle.component';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    CabeceraComponent,
    ContactoComponent,
    LandingComponent,
    LoginComponent,
    MenuComponent,
    VideojuegoComponent,
    VideojuegosComponent,
    DetalleComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
