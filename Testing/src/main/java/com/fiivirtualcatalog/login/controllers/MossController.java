package com.fiivirtualcatalog.login.controllers;


import com.fiivirtualcatalog.login.moss.Moss;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MossController {


     @CrossOrigin(origins = "http://localhost:9669")
    @RequestMapping(value={"/profesor/moss"}, method = RequestMethod.POST)
    public ResponseEntity<String> moss(@RequestParam String path1, @RequestParam String path2, @RequestParam String language) {
        String link;
        try {
            link="Link bun!";
            return new ResponseEntity<String>(link, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Exceptie!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
