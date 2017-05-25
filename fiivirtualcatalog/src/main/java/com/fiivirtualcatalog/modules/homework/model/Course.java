package com.fiivirtualcatalog.modules.homework.model;

import javax.persistence.*;

/**
 * Created by JACK on 5/8/2017.
 */
@Entity
@Table(name = "CURS")
public class Course {

    int id, an, credite;
    String denumire;

    public Course() {}

    public Course(int id, String denumire, int an, int credite) {
        this.id = id;
        this.denumire = denumire;
        this.an = an;
        this.credite = credite;
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

    @Column(name = "DENUMIRE")
    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Column(name = "AN")
    public int getAn() {
        return an;
    }
    public void setAn(int an_predare) {
        this.an = an_predare;
    }

    @Column(name = "CREDITE")
    public int getCredite() {
        return credite;
    }
    public void setCredite(int credite) {
        this.credite = credite;
    }
}
