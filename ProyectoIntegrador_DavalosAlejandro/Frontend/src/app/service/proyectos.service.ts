import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from '../model/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {
  URL= 'https://backend-agd.herokuapp.com/proyectos/';
  //URL= 'http://localhost:8080/proyectos/';

  constructor(private http: HttpClient) { }

  public get(): Observable<Proyecto[]>{
    console.log("El servicio portfolio proyectos esta corriendo");
    return this.http.get<Proyecto[]>(this.URL + 'lista');
  }

  public detail(id: number): Observable<Proyecto>{
    return this.http.get<Proyecto>(this.URL + `detail/${id}`);
  } 

 public save(proyecto: Proyecto): Observable<any>{
    return this.http.post<any>(this.URL + 'create', proyecto);
  }

  public edit(id: number, proyecto: Proyecto): Observable<any>{
    return this.http.put<any>(this.URL + `update/${id}`, proyecto);
  }

 public delete(id: number): Observable<any>{
    return this.http.delete<any>(this.URL + `delete/${id}`);
  }
}
