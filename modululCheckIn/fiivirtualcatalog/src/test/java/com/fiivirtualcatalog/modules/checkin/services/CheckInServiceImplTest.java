package com.fiivirtualcatalog.modules.checkin.services;

import com.fiivirtualcatalog.FiiVirtualCatalogApplication;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Test
    public void forSavingANewCheckInShouldReturnTheSameCheckIn() throws ParseException {
        CheckIn checkIn = new CheckIn();

        checkIn.setId(23);

        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);

        checkIn.setCreateDate(date);

        User user = new User();
        user.setName("Maria");
        user.setRole("Profesor");
        userRepository.save(user);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setName("Ana");
        user1.setRole("Student");
        User user2 = new User();
        user2.setName("Andrei");
        user2.setRole("Student");
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        checkIn.setCheckedInUsers(list);
        checkIn.setCode("ana");

        CheckIn newCheckIn = checkInService.save(checkIn);

        assertEquals(newCheckIn.getCreateDate().getClass(), checkIn.getCreateDate().getClass());
        assertEquals(newCheckIn.getUser().getName(), user.getName());
        assertEquals(newCheckIn.getUser().getRole(), user.getRole());
        assertEquals(newCheckIn.getSubject(), checkIn.getSubject());
        assertEquals(newCheckIn.getClassType(), checkIn.getClassType());
        assertEquals(newCheckIn.getNumberOfCheckedInUsers(), checkIn.getNumberOfCheckedInUsers());
        assertEquals(newCheckIn.getFinishingFlag(), checkIn.getFinishingFlag());
        assertEquals(newCheckIn.getCode(), checkIn.getCode());
        assertEquals(newCheckIn.getClass(), checkIn.getClass());
    }

    @Test
    public void forGettingAllCheckInsShouldReturnAListOfCheckIns() throws ParseException {
        CheckIn checkIn = new CheckIn();

        checkIn.setId(23);
        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);

        checkIn.setCreateDate(date);

        User user = new User();
        user.setName("Maria");
        user.setRole("Profesor");
        userRepository.save(user);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setName("Ana");
        user1.setRole("Student");
        User user2 = new User();
        user2.setName("Andrei");
        user2.setRole("Student");
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        checkIn.setCheckedInUsers(list);

        CheckIn newCheckIn = checkInService.save(checkIn);
        List<CheckIn> listOfCheckins = checkInService.getAll();

        //assertTrue(listOfCheckins.contains(checkIn));
        assertEquals(listOfCheckins.get(listOfCheckins.size() - 1), newCheckIn);
    }


    @Test
    public void forGettingByIdAnCheckInShouldReturnThatCheckIn() throws ParseException {
        CheckIn checkIn = new CheckIn();

        String dDate = "2011-11-11 12:16";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = formatter.parse(dDate);

        checkIn.setCreateDate(date);

        User user = new User();
        user.setName("Maria");
        user.setRole("Profesor");
        userRepository.save(user);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setName("Ana");
        user1.setRole("Student");
        User user2 = new User();
        user2.setName("Andrei");
        user2.setRole("Student");
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        checkIn.setCheckedInUsers(list);

        CheckIn checkInNew = checkInService.save(checkIn);
        List<CheckIn> listOfCheckins = checkInService.getAll();

        CheckIn newCheckIn = checkInService.getById(listOfCheckins.get(listOfCheckins.size() - 1).getId());

        assertEquals(newCheckIn, checkInNew);
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
        user.setName("Maria");
        user.setRole("Profesor");
        userRepository.save(user);
        checkIn.setUser(user);

        checkIn.setSubject("Subject");

        checkIn.setClassType("class-type");

        checkIn.setNumberOfCheckedInUsers(33);

        checkIn.setFinishingFlag(true);

        User user1 = new User();
        user1.setName("Ana");
        user1.setRole("Student");
        User user2 = new User();
        user2.setName("Andrei");
        user2.setRole("Student");
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        checkIn.setCheckedInUsers(list);

        CheckIn checkInSaved = checkInService.save(checkIn);
        checkInService.delete(checkInSaved.getId());
        assertEquals(checkInService.getById(checkInSaved.getId()), null);
    }

    @Test
    public void forCallingDeleteAllMethodShoulHaveNoCheckins() {
        checkInService.deleteAll();
        List<CheckIn> list = checkInService.getAll();
        assertTrue(list.isEmpty());
    }
}