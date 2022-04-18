import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { LandingComponent } from './componentes/landing/landing.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { VideojuegoComponent } from './componentes/videojuego/videojuego.component';
import { VideojuegosComponent } from './componentes/videojuegos/videojuegos.component';
import { LoginComponent } from './componentes/login/login.component';
import { DetalleComponent } from './componentes/detalle/detalle.component';

const routes: Routes = [
  {  path: '',
  component: LoginComponent
},

{
  path: 'componentMenu/:nombre/:password',
  component: MenuComponent
},

{
  path: 'componentLanding',
  component: LandingComponent
},

{
  path: 'componentContacto',
  component: ContactoComponent
},


{
  path: 'componentDetalles/:id/:titulo/:compania/:valoracion/:icono',
  component: DetalleComponent
},





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
