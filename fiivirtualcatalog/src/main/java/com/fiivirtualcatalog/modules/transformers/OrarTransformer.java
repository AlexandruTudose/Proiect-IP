package com.fiivirtualcatalog.modules.transformers;

import com.fiivirtualcatalog.modules.DTOs.OrarDTO;
import com.fiivirtualcatalog.modules.orar.models.Orar;
import org.springframework.stereotype.Component;

@Component
public class OrarTransformer implements Transformer<Orar, OrarDTO> {
    @Override
    public Orar toModel(OrarDTO object) {
        Orar orar=new Orar();
        orar.setZi(object.getZi());
        orar.setOraInceput(object.getOra_inceput());
        orar.setOraSfarsit(object.getOra_sfarsit());
        orar.setIdDisciplina(object.getId_disciplina());
        orar.setIdProf(object.getId_prof());
        orar.setSala(object.getSala());
        orar.setTip(object.getTip());
        return orar;
    }

    @Override
    public OrarDTO toDTO(Orar object) {
        return new OrarDTO(object.getZi(),object.getOraInceput(),object.getOraSfarsit(),object.getIdDisciplina(),
        object.getIdProf(),object.getSala(),object.getTip(),object.getGrupa());
    }
}
