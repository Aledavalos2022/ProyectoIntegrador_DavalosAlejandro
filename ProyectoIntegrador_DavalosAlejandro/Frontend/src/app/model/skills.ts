export class Skills {
    id?: number;
    skillsLevel: number;
    nombreSkill: string;
  
    constructor(nombreSkill:string, skillsLevel: number){
        this.nombreSkill = nombreSkill;
        this.skillsLevel = skillsLevel;
    }

}
