package com.fiivirtualcatalog.modules.checkin.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;

public class CheckInGetDTO {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private String subject;
    private ClassType classType;
    private String createDate;
    private long numberOfCheckedInUsers;
    private boolean finishingFlag;

    public CheckInGetDTO() {
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

    private CheckInGetDTO(Builder builder) {
        this.setSubject(builder.subject);
        this.setClassType(builder.classType);
        this.setNumberOfCheckedInUsers(builder.numberOfCheckedInUsers);
        this.setFinishingFlag(builder.finishingFlag);
        this.setCreateDate(builder.createDate);
    }

    public static class Builder {
        private String subject;
        private ClassType classType;
        private long numberOfCheckedInUsers;
        private boolean finishingFlag;
        private Date createDate;

        public Builder() {
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

        public CheckInGetDTO create() {
            return new CheckInGetDTO(this);
        }
    }
}
