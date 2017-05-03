package com.fiivirtualcatalog.login.controllers;

import com.fiivirtualcatalog.login.models.User;
import com.fiivirtualcatalog.login.moss.Moss;
import com.fiivirtualcatalog.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        User userExists = userService.findByEmail(user.getEmail());
        if (userExists != null) {
            return new ResponseEntity<User>(HttpStatus.valueOf("User already exists"));
        } else {
            userService.save(user);
            return new ResponseEntity<User>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<User>login(@RequestBody String email,@RequestBody String password){
        User userExists = userService.findByEmail(email);
        if (userExists == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else
            if(userExists.getPassword().compareTo(password)!=0)
                return new ResponseEntity<User>(HttpStatus.valueOf("Wrong password"));
        else
            return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(value="/admin/users", method = RequestMethod.POST)
    public ResponseEntity<User>delete(@RequestBody String email) {
        User userExists = userService.findByEmail(email);
        if (userExists == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } else {
            userService.delete(email);
            return new ResponseEntity<User>(HttpStatus.OK);
        }
    }

    @RequestMapping(value="/admin/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>>users(){
        List<User> students=this.userService.getAll();
        if(students.isEmpty())
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<List<User>>(students,HttpStatus.OK);
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value="/profesor/moss", method = RequestMethod.POST)
    public ModelAndView moss(@RequestParam String path1,@RequestParam String path2,@RequestParam String language) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject(Moss.getInstance().runMoss(path1,path2,language));
            modelAndView.setViewName("profesor/moss/results");
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("professor/moss?error=true");
            return modelAndView;
        }
    }
}
