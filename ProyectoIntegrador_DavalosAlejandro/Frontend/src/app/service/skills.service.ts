import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skills } from '../model/skills';

@Injectable({
  providedIn: 'root'
})
export class SkillsService {
  URL= 'https://backend-agd.herokuapp.com/skills/';
  //URL= 'http://localhost:8080/skills/';

  constructor(private http: HttpClient) { }

  public get(): Observable<Skills[]>{
    console.log("El servicio portfolio skills esta corriendo");
    return this.http.get<Skills[]>(this.URL + 'lista');
  }

  public detail(id: number): Observable<Skills>{
    return this.http.get<Skills>(this.URL + `detail/${id}`);
  } 

  public save(skills: Skills): Observable<any>{
    return this.http.post<any>(this.URL + 'create', skills);
  }

  public edit(id: number, skills: Skills): Observable<any>{
    return this.http.put<any>(this.URL + `update/${id}`, skills);
  }

  public delete(id: number): Observable<any>{
    return this.http.delete<any>(this.URL + `delete/${id}`);
  }
}
