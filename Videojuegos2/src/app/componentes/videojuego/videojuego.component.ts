import { Component, Input, OnInit } from '@angular/core';
import { Videojuego } from 'src/entidades/videojuego';
import {Router} from '@angular/router'


@Component({
  selector: 'app-videojuego',
  templateUrl: './videojuego.component.html',
  styleUrls: ['./videojuego.component.css']
})
export class VideojuegoComponent implements OnInit {

  @Input() videojuego: Videojuego;

  
 
  
  constructor() { 
    
  }

  ngOnInit() {
  }
 
}
