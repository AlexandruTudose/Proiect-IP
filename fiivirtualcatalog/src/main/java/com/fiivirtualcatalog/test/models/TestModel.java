package com.fiivirtualcatalog.test.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Alexandru on 4/27/2017.
 */

@Entity
@Table(name = "test")
public class TestModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String modelPropriety;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelPropriety() {
        return modelPropriety;
    }

    public void setModelPropriety(String modelPropriety) {
        this.modelPropriety = modelPropriety;
    }
}
