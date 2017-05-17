package com.ip.project.DTO;

/**
 * Created by JACK on 5/13/2017.
 */
public class TeacherDTO {

    int id;
    String nume;
    String prenume;

    public TeacherDTO(){}

    public TeacherDTO(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}
