package com.fiivirtualcatalog.modules.checkin.controllers;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.checkin.dtos.CheckInPostDTO;
import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.checkin.repositories.CheckInRepository;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class CheckInControllerTest {

    @Autowired
    private CheckInController checkInController;

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void forCallingGetMethodShouldReturnStatusOK() {
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.OK);
        ResponseEntity responseEntity = checkInController.get();

        assertEquals(responseEntity.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    public void forCallingGetMethodShouldReturnStatusNOContent() {
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.NO_CONTENT);
        checkInRepository.deleteAll();

        ResponseEntity responseEntity = checkInController.get();

        assertEquals(responseEntity.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    public void forCallingCreateCheckInMethodShouldReturnStatusCreated() {
        CheckInPostDTO checkInPostDTO = new CheckInPostDTO();
        checkInPostDTO.setUserId(1);
        checkInPostDTO.setSubject("Subject");
        checkInPostDTO.setClassType(ClassType.Course);

        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.CREATED);
        ResponseEntity responseEntity = checkInController.createCheckIn(checkInPostDTO);

        assertEquals(responseEntity.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    public void forCallingCreateCheckInMethodShouldReturnStatusForbidden() {
        CheckInPostDTO checkInPostDTO = new CheckInPostDTO();
        checkInPostDTO.setUserId(1);
        checkInPostDTO.setSubject("\'jjghj");
        checkInPostDTO.setClassType(ClassType.Course);

        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.FORBIDDEN);
        ResponseEntity responseEntity = checkInController.createCheckIn(checkInPostDTO);

        assertEquals(responseEntity, actualResponse);
    }


}