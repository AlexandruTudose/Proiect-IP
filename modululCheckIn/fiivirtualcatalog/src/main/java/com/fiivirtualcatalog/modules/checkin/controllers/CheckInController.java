package com.fiivirtualcatalog.modules.checkin.controllers;

import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.checkin.services.CheckInService;
import com.fiivirtualcatalog.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/check_ins")
public class CheckInController {

    @Autowired
    CheckInService checkInService;
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CheckIn>> get() {
        List<CheckIn> checkIns = this.checkInService.getAll();
        if (checkIns.isEmpty()) {
            return new ResponseEntity<List<CheckIn>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CheckIn>>(checkIns, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CheckIn> createCheckIn(@RequestBody CheckIn checkIn) {
        CheckIn savedCheckIn = this.checkInService.save(checkIn);
        return new ResponseEntity<CheckIn>(savedCheckIn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<CheckIn> registerCheckIn(@RequestBody long checkInId, long userId) {
        CheckIn searchCheckIn = this.checkInService.getById(checkInId);
        if (searchCheckIn == null)
            return new ResponseEntity<CheckIn>(HttpStatus.NOT_FOUND);
        searchCheckIn.addToCheckedInUsers(userService.getById(userId));
        this.checkInService.save(searchCheckIn);
        return new ResponseEntity<CheckIn>(searchCheckIn, HttpStatus.CREATED);
    }

}
