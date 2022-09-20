
import { Component, OnInit } from '@angular/core';
import { Skills } from 'src/app/model/skills';
import { SkillsService } from 'src/app/service/skills.service';
import { TokenService } from 'src/app/service/token.service';


@Component({
  selector: 'app-hys',
  templateUrl: './hys.component.html',
  styleUrls: ['./hys.component.css']
})
export class HysComponent implements OnInit {
  skills: Skills[] = [];

  

  constructor(private skillsService: SkillsService, private tokenService: TokenService) {}
  isLogged = false;

  ngOnInit(): void {
    this.cargarSkills();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }
  cargarSkills(): void{
    this.skillsService.get().subscribe(
      data => {
        this.skills = data;
      }
    )
  }



  delete(id: number){
    if(id != undefined){
      var resultado = window.confirm('Estas seguro de eliminar skill?');
      if (resultado === true) {
        window.alert('Okay, si estas seguro.');
        this.skillsService.delete(id).subscribe(
        data => {
          this.cargarSkills();
        }, err => {
          alert("No se pudo borrar la skill");
        }
      )
    }
  }
}
  }
  