package com.ip.project.model;

import javax.persistence.*;

/**
 * Created by JACK on 5/9/2017.
 */
@Entity
@Table(name = "PROFESOR")
public class Teacher {

    int id;
    String nume, prenume;

    public Teacher(){}

    public Teacher(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
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
}
