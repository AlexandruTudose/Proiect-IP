package com.fiivirtualcatalog.modules.homework.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JACK on 5/8/2017.
 */
@Entity
@Table(name = "TEMA")
public class Homework {

    int id, id_curs, id_student, id_nota;
    String tip_tema, fisier;
    Date data_predare;

    public Homework() {}

    public Homework(int id, int id_curs, int id_student, int id_nota, String tip_tema, String fisier, Date data_predare) {
        this.id = id;
        this.id_curs = id_curs;
        this.id_student = id_student;
        this.id_nota = id_nota;
        this.tip_tema = tip_tema;
        this.fisier = fisier;
        this.data_predare = data_predare;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ID_CURS")
    public int getId_curs() {
        return id_curs;
    }
    public void setId_curs(int id_curs) {
        this.id_curs = id_curs;
    }

    @Column(name = "ID_STUDENT")
    public int getId_student() {
        return id_student;
    }
    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    @Column(name = "ID_NOTA")
    public int getId_nota() {
        return id_nota;
    }
    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    @Column(name = "TIP_TEMA")
    public String getTip_tema() {
        return tip_tema;
    }
    public void setTip_tema(String tip_tema) {
        this.tip_tema = tip_tema;
    }

    @Column(name = "FISIER")
    public String getFisier() {
        return fisier;
    }
    public void setFisier(String fisier) {
        this.fisier = fisier;
    }

    @Column(name = "DATA_PREDARE")
    public Date getData_predare() {
        return data_predare;
    }
    public void setData_predare(Date data_predare) {
        this.data_predare = data_predare;
    }
}
