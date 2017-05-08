package com.fiivirtualcatalog.transformers;

import org.springframework.stereotype.Component;

import com.fiivirtualcatalog.modules.checkin.dtos.CheckInGetDTO;
import com.fiivirtualcatalog.modules.checkin.dtos.CheckInPostDTO;
import com.fiivirtualcatalog.modules.checkin.enums.ClassType;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;

@Component
public class CheckInTransformer {

    public CheckIn toModel(CheckInPostDTO object) {
        return new CheckIn.Builder()
                .subject(object.getSubject())
                .classType(object.getClassType().toString())
                .create();
    }

    public CheckInGetDTO toDTO(CheckIn object) {
        return new CheckInGetDTO.Builder()
                .subject(object.getSubject())
                .classType(ClassType.toEnum(object.getClassType()))
                .finishingFlag(object.getFinishingFlag())
                .numberOfCheckedInUsers(object.getNumberOfCheckedInUsers())
                .createDate(object.getCreateDate())
                .create();
    }

}