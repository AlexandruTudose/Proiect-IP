package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.models.CheckIn;


public class CheckInTransformer {

    public CheckIn toModel(CheckInPostDTO object) {
        System.out.println(object.getClassType() + object.getUserId());
        return new CheckIn().new Builder()
                .subject(object.getSubject())
                .classType(object.getClassType())
                .create();
    }

    public CheckInGetDTO toDTO(CheckIn object) {
        return new CheckInGetDTO().new Builder()
                .subject(object.getSubject())
                .classType(object.getClassType())
                .finishingFlag(object.getFinishingFlag())
                .numberOfCheckedInUsers(object.getNumberOfCheckedInUsers())
                .createDate(object.getCreateDate())
                .create();
    }

}