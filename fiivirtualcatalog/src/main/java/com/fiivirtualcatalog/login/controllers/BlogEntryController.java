package com.fiivirtualcatalog.login.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vladd on 09.05.2017.
 */
public class BlogEntryController {

    @RequestMapping("/test")
    public String test(){
        return "view";
    }
}
