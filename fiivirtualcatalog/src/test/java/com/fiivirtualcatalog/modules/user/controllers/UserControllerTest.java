package com.fiivirtualcatalog.modules.user.controllers;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.checkin.repositories.CheckInRepository;
import com.fiivirtualcatalog.modules.user.dtos.GetUserDTO;
import com.fiivirtualcatalog.modules.user.dtos.PostUserDTO;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
import com.fiivirtualcatalog.transformers.UserTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransformer transformer;

    @Test
    public void forANewUserWhenAddItShouldReturnCreatedHttpStatus() {
        PostUserDTO user = new PostUserDTO();
        user.setFirstName("Maria");
        user.setRole(User.Role.valueOf("profesor"));
        ResponseEntity responseEntity = userController.addUser(user);

        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.CREATED);
        assertEquals(responseEntity, actualResponse);
    }

    @Test
    public void forGettingAllUsersAndNoUserAreInDBShouldReturnNoContent() {
        checkInRepository.deleteAll();
        userRepository.deleteAll();
        ResponseEntity responseEntity = userController.get();
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.NO_CONTENT);
        assertEquals(responseEntity, actualResponse);
        assertTrue(true);
    }

    @Test
    public void forGettingAllUsersAndInDBAreAtLeastAUserShouldReturnOk() {
        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        userRepository.save(user);
        List<User> listOfUsers = userRepository.findAll();

        List<GetUserDTO> listOfUsersDTO = new ArrayList<>();
        for (User usr : listOfUsers) {
            listOfUsersDTO.add(transformer.toDTO(usr));
        }

        ResponseEntity responseEntity = userController.get();
        ResponseEntity actualResponse = new ResponseEntity(HttpStatus.OK);
        assertEquals(responseEntity.getStatusCode(), actualResponse.getStatusCode());
    }
}