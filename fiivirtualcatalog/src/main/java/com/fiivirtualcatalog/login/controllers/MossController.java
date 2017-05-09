package com.fiivirtualcatalog.login.controllers;

import com.fiivirtualcatalog.login.moss.Moss;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MossController {


    @RequestMapping(value="/profesor/moss", method = RequestMethod.POST)
    public ModelAndView moss(@RequestParam String path1, @RequestParam String path2, @RequestParam String language) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName(Moss.getInstance().runMoss(path1,path2,language));
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                modelAndView.setViewName(Moss.getInstance().runMoss(path1,path2,language));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return modelAndView;
        }
    }
}
