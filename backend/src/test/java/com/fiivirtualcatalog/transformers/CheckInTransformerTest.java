package com.fiivirtualcatalog.transformers;

import com.fiivirtualcatalog.modules.checkin.dtos.CheckInGetAllDTO;
import com.fiivirtualcatalog.modules.checkin.dtos.CheckInPostDTO;
import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckInTransformerTest {
    private CheckInTransformer checkInTransformer;

    @Before
    public void setUp() throws Exception {
        checkInTransformer = new CheckInTransformer();
    }

    @Test
    public void whenICallCheckInTransformerToModelShouldReturnACheckInWithSameCharacteristics() {
        CheckInPostDTO checkInPostDTO = new CheckInPostDTO();
        checkInPostDTO.setUserId(1);
        checkInPostDTO.setSubject("Subject");
        checkInPostDTO.setClassType(ClassType.Course);

        CheckIn checkIn = checkInTransformer.toModel(checkInPostDTO);

        assertEquals(checkIn.getSubject(), checkInPostDTO.getSubject());
        assertEquals(checkIn.getClassType(), "Course");
    }

    @Test
    public void whenICallCheckInTransformerToDTOShouldReturnACheckInWithSameCharacteristics() {
        CheckIn checkIn = new CheckIn();
        checkIn.setId(23);

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        checkIn.setCreateDate(currentTimestamp);

        User user = new User();
        user.setFirstName("Maria");
        user.setRole(User.Role.profesor);
        checkIn.setUser(user);
        checkIn.setSubject("Subject");
        checkIn.setClassType("Course");
        checkIn.setNumberOfCheckedInUsers(33);
        checkIn.setFinishingFlag(true);

        List<User> list = new ArrayList<>();
        checkIn.setCheckedInUsers(list);


        CheckInGetAllDTO checkInGetAllDTO = checkInTransformer.toGetAllDTO(checkIn);

        assertEquals(checkInGetAllDTO.getId(), checkIn.getId());
        assertEquals(checkInGetAllDTO.getSubject(), checkIn.getSubject());
        assertEquals(checkInGetAllDTO.getClassType(), ClassType.Course);
        assertEquals(checkInGetAllDTO.getNumberOfCheckedInUsers(), checkIn.getNumberOfCheckedInUsers());
        assertEquals(checkInGetAllDTO.getFinishingFlag(), checkIn.getFinishingFlag());
    }
}