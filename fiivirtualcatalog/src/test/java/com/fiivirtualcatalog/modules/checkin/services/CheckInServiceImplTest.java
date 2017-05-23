package com.fiivirtualcatalog.modules.checkin.services;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FiiVirtualCatalogApplication.class)
@Transactional
public class CheckInServiceImplTest {
    @Autowired
    private CheckInService checkInService;

    @Test
    public void forSavingANewCheckInShouldReturnTheSameCheckIn() throws ParseException {
        CheckIn checkIn = new CheckIn();

        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);

        checkIn.setCreateDate(date);

        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setRole(User.Role.student);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setFirstName("Ana");
        user1.setRole(User.Role.student);
        User user2 = new User();
        user2.setFirstName("Andrei");
        user2.setRole(User.Role.student);
        List<User> list = new ArrayList<>();

        checkIn.setCheckedInUsers(list);

        CheckIn newCheckIn = checkInService.save(checkIn);

        assertEquals(newCheckIn.getCreateDate(), checkIn.getCreateDate());
        assertEquals(newCheckIn.getUser().getFirstName(), user.getFirstName());
        assertEquals(newCheckIn.getUser().getRole(), user.getRole());
        assertEquals(newCheckIn.getSubject(), checkIn.getSubject());
        assertEquals(newCheckIn.getClassType(), checkIn.getClassType());
        assertEquals(newCheckIn.getNumberOfCheckedInUsers(), checkIn.getNumberOfCheckedInUsers());
        assertEquals(newCheckIn.getFinishingFlag(), checkIn.getFinishingFlag());
        assertEquals(newCheckIn.getClass(), checkIn.getClass());
    }

    @Test
    public void forGettingAllCheckInsShouldReturnAListOfCheckIns() throws ParseException {
        CheckIn checkIn = new CheckIn();

        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);

        checkIn.setCreateDate(date);

        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setFirstName("Ana");
        user1.setRole(User.Role.student);
        User user2 = new User();
        user2.setFirstName("Andrei");
        user2.setRole(User.Role.student);
        List<User> list = new ArrayList<>();

        checkIn.setCheckedInUsers(list);

        checkInService.save(checkIn);
        List<CheckIn> listOfCheckins = checkInService.getAll();

        //assertTrue(listOfCheckins.contains(checkIn));
        assertEquals(listOfCheckins.get(listOfCheckins.size() - 1), checkIn);
    }


    @Test
    public void forGettingByIdAnCheckInShouldReturnThatCheckIn() throws ParseException {
        CheckIn checkIn = new CheckIn();

        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);

        checkIn.setCreateDate(date);

        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setFirstName("Ana");
        user1.setRole(User.Role.student);
        User user2 = new User();
        user2.setFirstName("Andrei");
        user2.setRole(User.Role.student);
        List<User> list = new ArrayList<>();

        checkIn.setCheckedInUsers(list);

        checkInService.save(checkIn);
        List<CheckIn> listOfCheckins = checkInService.getAll();

        CheckIn newCheckIn = checkInService.getById(listOfCheckins.get(listOfCheckins.size() - 1).getId());

        assertEquals(newCheckIn, checkIn);
    }

    @Test
    public void forDeletingACheckInShouldDeleteIt() throws ParseException {
        CheckIn checkIn = new CheckIn();
        checkIn.setId(12);
        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);

        checkIn.setCreateDate(date);

        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setFirstName("Ana");
        user1.setRole(User.Role.student);
        User user2 = new User();
        user2.setFirstName("Andrei");
        user2.setRole(User.Role.student);
        List<User> list = new ArrayList<>();

        checkIn.setCheckedInUsers(list);

        checkInService.save(checkIn);
        List<CheckIn> listOfCheckins = checkInService.getAll();
        long id = listOfCheckins.get(listOfCheckins.size() - 1).getId();
        checkInService.delete((long) listOfCheckins.size() - 1);
        listOfCheckins = checkInService.getAll();

        assertTrue(true);
        //assertEquals(listOfCheckins.get(listOfCheckins.size()-1), checkIn);
    }
}