package com.fiivirtualcatalog.modules.orar.controllers;

import com.fiivirtualcatalog.modules.DTOs.OrarDTO;
import com.fiivirtualcatalog.modules.orar.services.OrarService;
import com.fiivirtualcatalog.modules.transformers.Transformer;
import com.fiivirtualcatalog.modules.transformers.OrarTransformer;
import com.fiivirtualcatalog.modules.orar.models.Orar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/orar")
public class OrarController {

    @Autowired
    private OrarService service;
    private Transformer<Orar, OrarDTO> transformer = new OrarTransformer();



}
