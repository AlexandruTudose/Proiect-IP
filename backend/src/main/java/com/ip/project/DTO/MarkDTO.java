package com.ip.project.DTO;

import java.util.Date;

/**
 * Created by JACK on 5/13/2017.
 */
public class MarkDTO {

    int id;
    int id_profesor;
    int valoare;
    Date data_notare;

    public MarkDTO(){}

    public MarkDTO(int id, int id_profesor, Date data_notare, int valoare) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.data_notare = data_notare;
        this.valoare = valoare;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getValoare() {
        return valoare;
    }
    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public Date getData_notare() {
        return data_notare;
    }
    public void setData_notare(Date data_notare) {
        this.data_notare = data_notare;
    }
}
