package com.ip.project.model;

import javax.persistence.*;

/**
 * Created by JACK on 5/2/2017.
 */
@Entity
@Table(name = "STUDENT")
public class Student {

    int nr_matricol, an;
    String nume, prenume, grupa;

    public Student() {}

    public Student(int nr_matricol, String nume, String prenume, String grupa, int an) {
        this.nr_matricol = nr_matricol;
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.an = an;
    }

    @Id
    @GeneratedValue
    @Column(name = "NR_MATRICOL")
    public int getNr_matricol() {
        return nr_matricol;
    }
    public void setNr_matricol(int nr_matricol) {
        this.nr_matricol = nr_matricol;
    }

    @Column(name = "NUME")
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Column(name = "PRENUME")
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Column(name = "GRUPA")
    public String getGrupa() {
        return grupa;
    }
    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    @Column(name = "AN")
    public int getAn() {
        return an;
    }
    public void setAn(int an) {
        this.an = an;
    }
}
