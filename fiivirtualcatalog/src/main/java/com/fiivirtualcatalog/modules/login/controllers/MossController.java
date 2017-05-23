package com.fiivirtualcatalog.modules.login.controllers;


import com.fiivirtualcatalog.modules.login.moss.Moss;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MossController {


     @CrossOrigin(origins = "http://localhost:3100")
    @RequestMapping(value={"/profesor/moss"}, method = RequestMethod.POST)
    public ResponseEntity<String> moss(@RequestParam String path1, @RequestParam String path2, @RequestParam String language) {
        String link;
        try {
            link= Moss.getInstance().runMoss(path1,path2,language);
            return new ResponseEntity<String>(link, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
