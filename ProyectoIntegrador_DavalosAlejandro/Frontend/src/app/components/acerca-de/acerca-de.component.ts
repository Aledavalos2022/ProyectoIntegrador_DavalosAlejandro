import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona.model';
import { AboutService } from 'src/app/service/about.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  public persona: Persona | undefined;
  
  public editPersona: Persona | undefined;

  constructor(private aboutService: AboutService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.getPerson();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
   
  }

  public getPerson(): void {
    this.aboutService.getPerson().subscribe({
      next: (response: Persona) => {
        this.persona = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  public onOpenModal(mode: string, persona?: Persona): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    button.setAttribute('data-bs-target', '#editAboutModal');

    container?.appendChild(button);
    button.click();
  }

  public onUpdateAbout(persona: Persona): void {
  
    this.editPersona = persona;
    this.aboutService.editPerson(persona).subscribe({
      next: (response: Persona) => {
        console.log(response);
        this.getPerson();
        alert("Guardado");
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  
}
