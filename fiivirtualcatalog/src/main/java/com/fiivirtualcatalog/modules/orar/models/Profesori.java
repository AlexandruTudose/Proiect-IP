package com.fiivirtualcatalog.modules.orar.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="profesori")
public class Profesori implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_prof;

    @NotNull
    @Column(name = "nume")
    private String nume;

    @NotNull
    @Column(name = "prenume")
    private String prenume;

    @Column(name = "grad_didactic")
    private String grad_didactic;

    public long getId_prof() {
        return id_prof;
    }

    public void setId_prof(long id_prof) {
        this.id_prof = id_prof;
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

    public String getGrad_didactic() {
        return grad_didactic;
    }

    public void setGrad_didactic(String grad_didactic) {
        this.grad_didactic = grad_didactic;
    }


}
