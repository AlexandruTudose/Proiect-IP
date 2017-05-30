package com.fiivirtualcatalog.modules.homework.DTO;

/**
 * Created by JACK on 5/13/2017.
 */
public class CourseDTO {

    int id;
    String denumire;
    int an;
    int credite;

    public CourseDTO(){}

    public CourseDTO(int id, String denumire, int an, int credite) {
        this.id = id;
        this.denumire = denumire;
        this.an = an;
        this.credite = credite;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getAn() {
        return an;
    }
    public void setAn(int an_predare) {
        this.an = an;
    }

    public int getCredite() {
        return credite;
    }
    public void setCredite(int credite) {
        this.credite = credite;
    }
}
