package com.fiivirtualcatalog.modules.orar.controllers;

import com.fiivirtualcatalog.modules.DTOs.OrarDTO;
import com.fiivirtualcatalog.modules.orar.models.Profesori;
import com.fiivirtualcatalog.modules.orar.repositories.OrarRepository;
import com.fiivirtualcatalog.modules.orar.services.OrarService;
import com.fiivirtualcatalog.modules.transformers.Transformer;
import com.fiivirtualcatalog.modules.transformers.OrarTransformer;
import com.fiivirtualcatalog.modules.orar.models.Orar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/orar")
public class OrarController {

    @Autowired
    private OrarService service;
    private Transformer<Orar, OrarDTO> transformer = new OrarTransformer();

    @RequestMapping(value="/crud/read",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> get() {
        List<Orar> orar = this.service.getAll();
        if (orar.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(orar, HttpStatus.OK);
    }


    @RequestMapping(value="/crud/create",method = RequestMethod.POST)
    public ResponseEntity<Orar> addEntry(@RequestBody OrarDTO orar) {
        Orar savedOrar = this.service.save(transformer.toModel(orar));
        return new ResponseEntity<Orar>(savedOrar, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/crud/delete/{deleteId}",method = RequestMethod.DELETE)
    public ResponseEntity<List<Orar>> deleteById(@PathVariable("deleteId") Long deleteId){

        Orar orar = this.service.getById(deleteId);
        if (orar == null) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }

        this.service.delete(deleteId);
        List<Orar> del = this.service.getAll();
        return new ResponseEntity<List<Orar>>(del, HttpStatus.OK);
    }


    @RequestMapping(value="/crud/update/{updateId}", method=RequestMethod.PUT)
    public ResponseEntity<Orar> updateById(@PathVariable("updateId") Long updateId, @RequestBody OrarDTO update) {
        Orar orar = this.service.getById(updateId);
        Orar orarUntouched=orar;
        if (orar == null) {
            return new ResponseEntity<Orar>(HttpStatus.NO_CONTENT);
        }
        Orar orarUpdate=transformer.toModel(update);

        orar.setZi(orarUpdate.getZi());
        orar.setOraInceput(orarUpdate.getOraInceput());
        orar.setOraSfarsit(orarUpdate.getOraSfarsit());
        orar.setIdDisciplina(orarUpdate.getIdDisciplina());
        orar.setIdProf(orarUpdate.getIdProf());
        orar.setSala(orarUpdate.getSala());
        orar.setTip(orarUpdate.getTip());
        orar.setGrupa(orarUpdate.getGrupa());
        Orar orarSaved=this.service.save(orar);
        return new ResponseEntity<Orar>(orarSaved, HttpStatus.OK);
    }

    @RequestMapping(value="/filter/byOra/{ora}",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> getByOra_inceput(@PathVariable("ora") String ora) {
        List<Orar> orars = this.service.getAll();
        List<Orar> bun = new ArrayList<>();
        for(Orar orar : orars)
            if(orar.getOraInceput().equals(Time.valueOf(ora)))
                bun.add(orar);
        if (bun.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(bun, HttpStatus.OK);
    }

    @RequestMapping(value="/filter/byProfId/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> getByProfId(@PathVariable("id")  Long id) {
        List<Orar> orars = this.service.getAll();
        List<Orar> bun = new ArrayList<>();
        for(Orar orar : orars)
            if(orar.getIdProf()==id)
                bun.add(orar);
        if (bun.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(bun, HttpStatus.OK);
    }

    @RequestMapping(value="/filter/byDisciplinaId/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> getByDisciplinaId(@PathVariable("id")  Long id) {
        List<Orar> orars = this.service.getAll();
        List<Orar> bun = new ArrayList<>();
        for(Orar orar : orars)
            if(orar.getIdDisciplina()==id)
                bun.add(orar);
        if (bun.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(bun, HttpStatus.OK);
    }


    @RequestMapping(value="/filter/bySala/{numar}",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> getBySala(@PathVariable("numar")  Long numar) {
        List<Orar> orars = this.service.getAll();
        List<Orar> bun = new ArrayList<>();
        for(Orar orar : orars)
            if(orar.getSala()==numar)
                bun.add(orar);
        if (bun.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(bun, HttpStatus.OK);
    }


    @RequestMapping(value="/filter/byZi/{zi}",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> getZi(@PathVariable("zi") String zi) {
        List<Orar> orars = this.service.getAll();
        List<Orar> bun = new ArrayList<>();
        for(Orar orar : orars)
            if(orar.getZi().toLowerCase().equals(zi.toLowerCase()))
                bun.add(orar);
        if (bun.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(bun, HttpStatus.OK);
    }


    @RequestMapping(value="/filter/byGrupa/{grupa}",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> getByGrupa(@PathVariable("grupa") String grupa) {
        List<Orar> orars = this.service.getAll();
        List<Orar> bun = new ArrayList<>();
        for(Orar orar : orars)
            if(orar.getGrupa().toLowerCase().equals(grupa.toLowerCase()))
                bun.add(orar);
        if (bun.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(bun, HttpStatus.OK);
    }

    @RequestMapping(value="/filter/byProfAndDisciplina/{prof}/{disciplina}",method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> getByProfAndDisciplina(@PathVariable("prof") Long id_prof,@PathVariable("disciplina") Long id_disciplina ) {
        List<Orar> orars = this.service.getAll();
        List<Orar> bun = new ArrayList<>();
        for(Orar orar : orars)
            if(orar.getIdProf()==id_prof&&orar.getIdDisciplina()==id_disciplina)
                bun.add(orar);
        if (bun.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(bun, HttpStatus.OK);
    }
}
