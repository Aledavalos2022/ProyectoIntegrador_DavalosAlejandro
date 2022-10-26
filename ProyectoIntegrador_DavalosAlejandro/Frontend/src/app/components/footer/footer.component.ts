import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  public persona: Persona | undefined;

  constructor(private personaService: PersonaService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.getPerson();
  }

  public getPerson(): void {
    this.personaService.detail(1).subscribe({
      next: (response: Persona) => {
        this.persona = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

}
