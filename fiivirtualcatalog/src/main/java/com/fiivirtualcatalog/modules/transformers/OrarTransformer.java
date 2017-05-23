package com.fiivirtualcatalog.modules.transformers;

import com.fiivirtualcatalog.modules.DTOs.OrarDTO;
import com.fiivirtualcatalog.modules.orar.models.Orar;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class OrarTransformer implements Transformer<Orar, OrarDTO> {
    @Override
    public Orar toModel(OrarDTO object) {
        Orar orar=new Orar();
        orar.setZi(object.getZi());
        orar.setOraInceput(Time.valueOf(object.getOra_inceput()));
        orar.setOraSfarsit(Time.valueOf(object.getOra_sfarsit()));
        orar.setIdDisciplina(object.getId_disciplina());
        orar.setIdProf(object.getId_prof());
        orar.setSala(object.getSala());
        orar.setTip(object.getTip());
        orar.setGrupa(object.getGrupa());
        return orar;
    }

    @Override
    public OrarDTO toDTO(Orar object) {
        return new OrarDTO(object.getZi(),String.valueOf(object.getOraInceput()),String.valueOf(object.getOraSfarsit()),
                object.getIdDisciplina(), object.getIdProf(),object.getSala(),object.getTip(),object.getGrupa());
    }
}
