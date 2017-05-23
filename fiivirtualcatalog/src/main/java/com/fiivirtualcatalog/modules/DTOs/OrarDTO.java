package com.fiivirtualcatalog.modules.DTOs;


public class OrarDTO {
    private String zi;
    private String grupa;
    private int id_disciplina;
    private int id_prof;
    private String ora_inceput;
    private String ora_sfarsit;
    private int sala;
    private String tip;

    public OrarDTO(){

    }
    public OrarDTO(String zi, String ora_inceput, String ora_sfarsit,  int id_disciplina, int id_prof,int sala, String tip, String grupa) {
        this.zi = zi;
        this.grupa = grupa;
        this.id_disciplina = id_disciplina;
        this.id_prof = id_prof;
        this.ora_inceput = ora_inceput;
        this.ora_sfarsit = ora_sfarsit;
        this.sala = sala;
        this.tip = tip;
    }


    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public String getOra_inceput() {
        return ora_inceput;
    }

    public void setOra_inceput(String ora_inceput) {
        this.ora_inceput = ora_inceput;
    }

    public String getOra_sfarsit() {
        return ora_sfarsit;
    }

    public void setOra_sfarsit(String ora_sfarsit) {
        this.ora_sfarsit = ora_sfarsit;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }


}
