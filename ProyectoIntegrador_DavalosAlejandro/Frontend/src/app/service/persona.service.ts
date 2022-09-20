import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../model/persona.model'
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  //URL= 'https://backend-agd.herokuapp.com/';
  URL= 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  public getPersona():Observable<Persona>{
    return this.http.get<Persona>(this.URL+"")
  }
}
