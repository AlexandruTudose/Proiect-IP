package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;

import java.util.Date;
import java.util.List;

public class CheckInGetByIdDTO extends CheckInGetAllDTO {
    private List<SimpleUser> simpleUsers;

    public List<SimpleUser> getSimpleUsers() {
        return simpleUsers;
    }

    public void setSimpleUsers(List<SimpleUser> simpleUsers) {
        this.simpleUsers = simpleUsers;
    }


    public CheckInGetByIdDTO(){

    }
    public static class SimpleUser {
        private long id;
        private String userName;
        public SimpleUser(long id, String userName) {
            this.id = id;
            this.userName = userName;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

// TODO: @alexT - find a nicer way to build this user data list when integrate. Also check CheckInTransformer.

    public static class NewBuilder extends Builder {
        private List<SimpleUser> simpleUsers;

        public NewBuilder id(long id) {
            this.id = id;
            return this;
        }

        public NewBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public NewBuilder classType(ClassType classType) {
            this.classType = classType;
            return this;
        }

        public NewBuilder numberOfCheckedInUsers(long numberOfCheckedInUsers) {
            this.numberOfCheckedInUsers = numberOfCheckedInUsers;
            return this;
        }

        public NewBuilder finishingFlag(boolean finishingFlag) {
            this.finishingFlag = finishingFlag;
            return this;
        }

        public NewBuilder createDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }

        public NewBuilder createUsers(List<SimpleUser> simpleUsers) {
            this.simpleUsers = simpleUsers;
            return this;
        }

        public CheckInGetByIdDTO create() {
            return new CheckInGetByIdDTO(this);
        }
    }

    private CheckInGetByIdDTO(NewBuilder builder) {
        this.setId(builder.id);
        this.setSubject(builder.subject);
        this.setClassType(builder.classType);
        this.setNumberOfCheckedInUsers(builder.numberOfCheckedInUsers);
        this.setFinishingFlag(builder.finishingFlag);
        this.setCreateDate(builder.createDate);
        this.setSimpleUsers(builder.simpleUsers);
    }
}
