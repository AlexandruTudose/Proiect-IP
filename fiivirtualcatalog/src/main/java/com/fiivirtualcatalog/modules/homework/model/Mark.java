package com.fiivirtualcatalog.modules.homework.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JACK on 5/9/2017.
 */
@Entity
@Table(name = "NOTA")
public class Mark {

    int id, valoare, id_profesor;
    Date data_notare;

    public Mark(){}

    public Mark(int id, int id_profesor, int valoare, Date data_notare) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.valoare = valoare;
        this.data_notare = data_notare;
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

    @Column(name = "ID_PROF")
    public int getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    @Column(name = "VALOARE")
    public int getValoare() {
        return valoare;
    }
    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    @Column(name = "DATA_NOTARE")
    public Date getData_notare() {
        return data_notare;
    }
    public void setData_notare(Date data_notare) {
        this.data_notare = data_notare;
    }
}
