package com.ip.project.DTO;

import java.util.Date;

/**
 * Created by JACK on 5/13/2017.
 */
public class HomeworkDTO {

    int id;
    int id_curs;
    int id_student;
    int id_nota;
    String tip_tema;
    String fisier;
    Date data_predare;

    public HomeworkDTO(){}

    public HomeworkDTO(int id, int id_curs, int id_student, int id_nota, String tip_tema, String fisier, Date data_predare) {
        this.id = id;
        this.id_curs = id_curs;
        this.id_student = id_student;
        this.id_nota = id_nota;
        this.tip_tema = tip_tema;
        this.fisier = fisier;
        this.data_predare = data_predare;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId_curs() {
        return id_curs;
    }
    public void setId_curs(int id_curs) {
        this.id_curs = id_curs;
    }

    public int getId_student() {
        return id_student;
    }
    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_nota() {
        return id_nota;
    }
    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public String getTip_tema() {
        return tip_tema;
    }
    public void setTip_tema(String tip_tema) {
        this.tip_tema = tip_tema;
    }

    public String getFisier() {
        return fisier;
    }
    public void setFisier(String fisier) {
        this.fisier = fisier;
    }

    public Date getData_predare() {
        return data_predare;
    }
    public void setData_predare(Date data_predare) {
        this.data_predare = data_predare;
    }
}
