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

    @Test
    public void forCallingRegisterCheckInMethodWithAnWrongCheckInIdShouldReturnNotFound() throws ParseException {
        checkInRepository.deleteAll();

        User newUser = new User();
        newUser.setFirstName("MAria");
        newUser.setRole(User.Role.student);

        User logedUser = userRepository.save(newUser);
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.NOT_FOUND);
        ResponseEntity responseEntity = checkInController.registerCheckIn(logedUser.getId(), (long) 2);

        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forCallingRegisterCheckInMethodWithAnFalseFlagCheckInIdShouldReturnForbidden() {
        CheckIn checkIn = new CheckIn();
        checkIn.setId(23);

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);
        checkIn.setSubject("Subject");
        checkIn.setClassType("class-type");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(true);

        List<User> list = new ArrayList<>();
        checkIn.setCheckedInUsers(list);

        User userSaved = userRepository.save(user);
        CheckIn checkInSaved = checkInRepository.save(checkIn);

        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.FORBIDDEN);
        ResponseEntity responseEntity = checkInController.registerCheckIn(userSaved.getId(), checkInSaved.getId());

        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forCallingRegisterCheckInMethodWithAnWrongUserIdShouldReturnsNotFound() {
        CheckIn checkIn = new CheckIn();
        checkIn.setId(23);

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);
        checkIn.setSubject("Subject");
        checkIn.setClassType("class-type");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(false);

        List<User> list = new ArrayList<>();
        checkIn.setCheckedInUsers(list);

        userRepository.save(user);
        CheckIn checkInSaved = checkInRepository.save(checkIn);

        List<User> listOfUsers = userRepository.findAll();
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.NOT_FOUND);
        ResponseEntity responseEntity = checkInController.registerCheckIn(listOfUsers.get(listOfUsers.size() - 1).getId() + 10, checkInSaved.getId());

        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forCallingRegisterCheckInMethodWithTheSameUserIdFromCheckedInUsersIdShouldReturnForbidden() {
        CheckIn checkIn = new CheckIn();

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);
        checkIn.setSubject("Subject");
        checkIn.setClassType("Laboratory");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(false);

        User userSaved = userRepository.save(user);
        List<User> list = new ArrayList<>();
        list.add(userSaved);
        checkIn.setCheckedInUsers(list);
        CheckIn checkInSaved = checkInRepository.save(checkIn);

        List<User> listUsers = checkInSaved.getCheckedInUsers();
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.FORBIDDEN);
        ResponseEntity responseEntity = checkInController.registerCheckIn(listUsers.get(listUsers.size() - 1).getId(), checkInSaved.getId());

        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forCallingRegisterCheckInMethodShouldReturnCreated() {
        CheckIn checkIn = new CheckIn();

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");
        checkIn.setClassType("Laboratory");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(false);

        List<User> list = new ArrayList<>();
        checkIn.setCheckedInUsers(list);
        User userSaved = userRepository.save(user);
        CheckIn checkInSaved = checkInRepository.save(checkIn);

        List<User> listUsers = checkInSaved.getCheckedInUsers();
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.CREATED);
        ResponseEntity responseEntity = checkInController.registerCheckIn(userSaved.getId(), checkInSaved.getId());

        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forCallingEndCheckInWithAWrongCheckInIdShouldReturnNotFound() {
        checkInRepository.deleteAll();

        User newUser = new User();
        newUser.setFirstName("Ana");
        newUser.setRole(User.Role.profesor);

        User logedUser = userRepository.save(newUser);
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.NOT_FOUND);
        ResponseEntity responseEntity = checkInController.endCheckIn(logedUser.getId(), (long) 2);

        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forCallingEndCheckInWithAUserIdNotEqualWithUserFromCheckInShouldReturnForbidden() {
        CheckIn checkIn = new CheckIn();
        checkIn.setId(23);

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);

        User userSaved = userRepository.save(user);
        checkIn.setUser(userSaved);
        checkIn.setSubject("Subject");
        checkIn.setClassType("class-type");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(false);
        List<User> list = new ArrayList<>();
        checkIn.setCheckedInUsers(list);

        User user2 = new User();
        user2.setFirstName("Laura");
        user2.setRole(User.Role.profesor);
        userSaved = userRepository.save(user2);
        CheckIn checkInSaved = checkInRepository.save(checkIn);

        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.FORBIDDEN);
        ResponseEntity responseEntity = checkInController.endCheckIn(userSaved.getId(), checkInSaved.getId());

        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forCallingEndCheckInWithAUserIdEqualWithUserFromCheckInShouldReturnCreated() {
        CheckIn checkIn = new CheckIn();
        checkIn.setId(23);

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);

        User userSaved = userRepository.save(user);
        checkIn.setUser(userSaved);
        checkIn.setSubject("Subject");
        checkIn.setClassType("class-type");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(false);
        List<User> list = new ArrayList<>();
        checkIn.setCheckedInUsers(list);

        CheckIn checkInSaved = checkInRepository.save(checkIn);

        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.CREATED);
        ResponseEntity responseEntity = checkInController.endCheckIn(userSaved.getId(), checkInSaved.getId());

        assertEquals(responseEntity, actualResponse);
    }
}