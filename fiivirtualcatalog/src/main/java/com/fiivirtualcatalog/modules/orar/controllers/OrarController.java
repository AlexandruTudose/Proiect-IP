package com.fiivirtualcatalog.modules.orar.controllers;

import com.fiivirtualcatalog.modules.DTOs.OrarDTO;
import com.fiivirtualcatalog.modules.orar.services.OrarService;
import com.fiivirtualcatalog.modules.transformers.Transformer;
import com.fiivirtualcatalog.modules.transformers.OrarTransformer;
import com.fiivirtualcatalog.modules.orar.models.Orar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/orar")
public class OrarController {

    @Autowired
    private OrarService service;
    private Transformer<Orar, OrarDTO> transformer = new OrarTransformer();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Orar>> get() {
        List<Orar> orar = this.service.getAll();
        if (orar.isEmpty()) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orar>>(orar, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Orar> addEntry(@RequestBody OrarDTO orar) {
        Orar savedOrar = this.service.save(transformer.toModel(orar));
        return new ResponseEntity<Orar>(savedOrar, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{deleteId}",method = RequestMethod.DELETE)
    public ResponseEntity<List<Orar>> deleteEntry(@PathVariable("deleteId") Long deleteId){

        Orar orar = this.service.getById(deleteId);
        if (orar == null) {
            return new ResponseEntity<List<Orar>>(HttpStatus.NO_CONTENT);
        }

        this.service.delete(deleteId);
        List<Orar> del = this.service.getAll();
        return new ResponseEntity<List<Orar>>(del, HttpStatus.OK);
    }
}
