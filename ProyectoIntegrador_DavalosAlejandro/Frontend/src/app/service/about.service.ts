import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class AboutService {
  // URL= 'https://backend-agd.herokuapp.com';
  URL= 'http://localhost:8080';


  constructor(private http:HttpClient) { }

  public getPerson():Observable<Persona>{
    return this.http.get<Persona>(`${this.URL}/ver/personas/1`);
  }

  public editPerson(persona: Persona): Observable<Persona>{
    return this.http.put<Persona>(`${this.URL}/personas/update`,persona);
  }
}
