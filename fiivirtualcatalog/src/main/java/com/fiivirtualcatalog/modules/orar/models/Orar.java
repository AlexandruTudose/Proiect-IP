package com.fiivirtualcatalog.modules.orar.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orar")
public class Orar implements Serializable {
    private static final long serialVersionUID = -5607554818203808048L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "zi")
    private String zi;

    @NotNull
    @Column(name = "ora_inceput")
    private Time oraInceput;

    @NotNull
    @Column(name = "ora_sfarsit")
    private Time oraSfarsit;

    @NotNull
    @Column(name = "id_disciplina")
    private int idDisciplina;

    @NotNull
    @Column(name = "id_prof")
    private int idProf;

    @NotNull
    @Column(name = "sala")
    private int sala;

    @Column(name = "tip")
    private String tip;

    @Column(name = "grupa")
    private String grupa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public Time getOraInceput() {
        return oraInceput;
    }

    public void setOraInceput(Time oraInceput) {
        this.oraInceput = oraInceput;
    }

    public Time getOraSfarsit() {
        return oraSfarsit;
    }

    public void setOraSfarsit(Time oraSfarsit) {
        this.oraSfarsit = oraSfarsit;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
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

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }



}