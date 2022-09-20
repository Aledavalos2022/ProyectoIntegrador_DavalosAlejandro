
package com.portfolio.davalosAlejandro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="skills_level")
    private int skillsLevel;
    
    @Column(name="nombre_skill")
    private String nombreSkill;
    
    //@Column(name="img_skill")
   // private String imgSkill;
    //Constructor

    public Skills() {
    }

    public Skills(int id, int skillsLevel, String nombreSkill) {
        this.id = id;
        this.skillsLevel = skillsLevel;
        this.nombreSkill = nombreSkill;
    }

    public Skills(int skillsLevel, String nombreSkill) {
        this.skillsLevel = skillsLevel;
        this.nombreSkill = nombreSkill;
    }

}
