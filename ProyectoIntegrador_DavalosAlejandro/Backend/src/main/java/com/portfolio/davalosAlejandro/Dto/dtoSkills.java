/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.davalosAlejandro.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkills {
     @NotBlank   
     private int skillsLevel;
     @NotBlank  
     private String nombreSkill;
     //private String imgSkill;

    public dtoSkills() {
    }

    public dtoSkills(int skillsLevel, String nombreSkill) {
        this.skillsLevel = skillsLevel;
        this.nombreSkill = nombreSkill;
    }

    public int getSkillsLevel() {
        return skillsLevel;
    }

    public void setSkillsLevel(int skillsLevel) {
        this.skillsLevel = skillsLevel;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }     
     
}
