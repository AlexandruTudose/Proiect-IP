package com.fiivirtualcatalog.transformers;

import com.fiivirtualcatalog.modules.checkin.dtos.CheckInGetAllDTO;
import com.fiivirtualcatalog.modules.checkin.dtos.CheckInGetByIdDTO;
import com.fiivirtualcatalog.modules.checkin.dtos.CheckInPostDTO;
import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.user.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckInTransformer {

    public CheckIn toModel(CheckInPostDTO object) {
        return new CheckIn.Builder()
                .subject(object.getSubject())
                .classType(object.getClassType().toString())
                .create();
    }

    public CheckInGetAllDTO toGetAllDTO(CheckIn object) {
        return new CheckInGetAllDTO.Builder()
                .id(object.getId())
                .subject(object.getSubject())
                .classType(ClassType.toEnum(object.getClassType()))
                .finishingFlag(object.getFinishingFlag())
                .numberOfCheckedInUsers(object.getNumberOfCheckedInUsers())
                .createDate(object.getCreateDate())
                .create();
    }

    public CheckInGetByIdDTO toGetByIdDTO(CheckIn object) {
        List<CheckInGetByIdDTO.SimpleUser> simpleUsers = new ArrayList<>();
        for (User user : object.getCheckedInUsers()) {
            simpleUsers.add(new CheckInGetByIdDTO.SimpleUser(user.getId(), user.getFirstName(), user.getLastName()));
        }
        return new CheckInGetByIdDTO.NewBuilder()
                .id(object.getId())
                .subject(object.getSubject())
                .classType(ClassType.toEnum(object.getClassType()))
                .finishingFlag(object.getFinishingFlag())
                .numberOfCheckedInUsers(object.getNumberOfCheckedInUsers())
                .createDate(object.getCreateDate())
                .createUsers(simpleUsers)
                .create();
    }
}