package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckInGetAllDTO {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private long id;
    private String subject;
    private ClassType classType;
    private String createDate;
    private long numberOfCheckedInUsers;
    private boolean finishingFlag;

    public CheckInGetAllDTO() {
    }

    public String getSubject() {
        return subject;
    }

    public ClassType getClassType() {
        return classType;
    }

    public long getNumberOfCheckedInUsers() {
        return numberOfCheckedInUsers;
    }

    public boolean getFinishingFlag() {
        return finishingFlag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = dateFormat.format(createDate);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public void setNumberOfCheckedInUsers(long numberOfCheckedInUsers) {
        this.numberOfCheckedInUsers = numberOfCheckedInUsers;
    }

    public void setFinishingFlag(boolean finishingFlag) {
        this.finishingFlag = finishingFlag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private CheckInGetAllDTO(Builder builder) {
        this.setId(builder.id);
        this.setSubject(builder.subject);
        this.setClassType(builder.classType);
        this.setNumberOfCheckedInUsers(builder.numberOfCheckedInUsers);
        this.setFinishingFlag(builder.finishingFlag);
        this.setCreateDate(builder.createDate);
    }

    public static class Builder {
        long id;
        String subject;
        ClassType classType;
        long numberOfCheckedInUsers;
        boolean finishingFlag;
        Date createDate;

        public Builder() {
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder classType(ClassType classType) {
            this.classType = classType;
            return this;
        }

        public Builder numberOfCheckedInUsers(long numberOfCheckedInUsers) {
            this.numberOfCheckedInUsers = numberOfCheckedInUsers;
            return this;
        }

        public Builder finishingFlag(boolean finishingFlag) {
            this.finishingFlag = finishingFlag;
            return this;
        }

        public Builder createDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }

        public CheckInGetAllDTO create() {
            return new CheckInGetAllDTO(this);
        }
    }
}
