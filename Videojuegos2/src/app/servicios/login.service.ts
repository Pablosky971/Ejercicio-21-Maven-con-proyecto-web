import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  readonly endPoint = 'http://localhost:8080/21_WebLogin/usuarios/login'

  constructor(private _httpclient : HttpClient) { 

  }

  public login(nombre:String,password:String):Observable<any> {
    return this._httpclient.get<any>(`${this.endPoint}?nombre=${nombre}&password=${password}`).pipe(catchError(this.manejarError))
  }

  private manejarError(e: HttpErrorResponse){
    let mensajeError = ''
    if (e.error instanceof ErrorEvent) {
      mensajeError = 'A ocurrido un error:' + e.error
    } else {
      mensajeError = `El servicio Rest retorno: Status: ${e.status}, ` +
            `Body: ${e.error}`
    }
    console.error(mensajeError)
    return throwError(() => new Error(mensajeError));
  }
}
