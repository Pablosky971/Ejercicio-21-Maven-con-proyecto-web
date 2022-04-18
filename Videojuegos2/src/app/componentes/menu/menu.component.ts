import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, RouteConfigLoadEnd} from '@angular/router';
import { Usuario } from 'src/entidades/usuario';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  
  static nombre: string = ""
  static password: string = ""
  constructor() { 
    
  }

  ngOnInit() {
  }

}
