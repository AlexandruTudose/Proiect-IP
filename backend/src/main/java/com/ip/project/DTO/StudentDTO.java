package com.ip.project.DTO;

/**
 * Created by JACK on 5/13/2017.
 */
public class StudentDTO {

    int nr_matricol;
    String nume;
    String prenume;
    String grupa;
    int an;

    public StudentDTO(){}

    public StudentDTO(int nr_matricol, String nume, String prenume, String grupa, int an) {
        this.nr_matricol = nr_matricol;
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.an = an;
    }

    public int getNr_matricol() {
        return nr_matricol;
    }
    public void setNr_matricol(int nr_matricol) {
        this.nr_matricol = nr_matricol;
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

    public String getGrupa() {
        return grupa;
    }
    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public int getAn() {
        return an;
    }
    public void setAn(int an) {
        this.an = an;
    }
}
