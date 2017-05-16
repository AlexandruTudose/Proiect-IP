package com.fiivirtualcatalog.modules.checkin.controllers;

import com.fiivirtualcatalog.modules.checkin.dtos.CheckInGetAllDTO;
import com.fiivirtualcatalog.modules.checkin.dtos.CheckInGetByIdDTO;
import com.fiivirtualcatalog.modules.checkin.dtos.CheckInPostDTO;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.checkin.services.CheckInService;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import com.fiivirtualcatalog.transformers.CheckInTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/v1/checkins")
public class CheckInController {

    @Autowired
    CheckInService checkInService;
    @Autowired
    UserService userService;
    @Autowired
    CheckInTransformer transformer;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CheckInGetAllDTO>> get() {
        List<CheckIn> checkIns = this.checkInService.getAll();
        if (checkIns.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<CheckInGetAllDTO> checkInGetAllDTOS = new ArrayList<>();
        for (CheckIn checkIn : checkIns) {
            checkInGetAllDTOS.add(transformer.toGetAllDTO(checkIn));
        }
        return new ResponseEntity<>(checkInGetAllDTOS, HttpStatus.OK);
    }

    @RequestMapping(value = "/{checkInId}", method = RequestMethod.GET)
    public ResponseEntity<CheckInGetByIdDTO> getById(@PathVariable("checkInId") Long checkInId) {
        CheckIn checkIn = this.checkInService.getById(checkInId);
        if (checkIn == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transformer.toGetByIdDTO(checkIn), HttpStatus.OK);
    }

    @RequestMapping(value = "/{checkInId}/{checkedInUserId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("checkInId") Long checkInId, @PathVariable("checkedInUserId") Long userId) {
        CheckIn checkIn = this.checkInService.getById(checkInId);
        if (checkIn == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        if (checkIn.getFinishingFlag()) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        checkIn.removeFromCheckedInUsers(userService.getById(userId));
        this.checkInService.save(checkIn);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCheckIn(@RequestBody CheckInPostDTO checkInPost) {
        if (!checkInPost.getSubject().matches("[a-zA-Z ]+")) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        CheckIn checkIn = transformer.toModel(checkInPost);
        User user = userService.getById(checkInPost.getUserId());
        checkIn.setUser(user);
        this.checkInService.save(checkIn);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/register/{userId}", method = RequestMethod.POST)
    public ResponseEntity registerCheckIn(@PathVariable("userId") Long userId, @RequestBody Long checkInId) {

        CheckIn searchCheckIn = this.checkInService.getById(checkInId);

        if (searchCheckIn == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        if (searchCheckIn.getFinishingFlag()) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        try {
            userService.existsUser(userId);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (searchCheckIn.getCheckedInUsers().contains(userService.getById(userId))) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        searchCheckIn.addToCheckedInUsers(userService.getById(userId));
        this.checkInService.save(searchCheckIn);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{checkInId}/end/{userId}", method = RequestMethod.POST)
    public ResponseEntity endCheckIn(@PathVariable("userId") Long userId, @PathVariable("checkInId") Long checkInId) {
        CheckIn searchCheckIn = this.checkInService.getById(checkInId);
        if (searchCheckIn == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (searchCheckIn.getUser().getId() != userId) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        searchCheckIn.setFinishingFlag(true);
        this.checkInService.save(searchCheckIn);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
