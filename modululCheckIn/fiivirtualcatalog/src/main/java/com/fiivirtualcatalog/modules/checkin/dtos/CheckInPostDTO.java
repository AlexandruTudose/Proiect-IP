package com.fiivirtualcatalog.modules.checkin.dtos;

import com.fiivirtualcatalog.modules.checkin.enums.ClassType;

public class CheckInPostDTO {
    private long userId;
    private String subject;
    private ClassType classType;

    public CheckInPostDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    private CheckInPostDTO(Builder builder) {
        this.setUserId(builder.userId);
        this.setSubject(builder.subject);
        this.setClassType(builder.classType);
    }

    public static class Builder {
        private long userId;
        private String subject;
        private ClassType classType;

        public Builder() {
        }

        public CheckInPostDTO.Builder user(long userId) {
            this.userId = userId;
            return this;
        }

        public CheckInPostDTO.Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public CheckInPostDTO.Builder classType(ClassType classType) {
            this.classType = classType;
            return this;
        }

        public CheckInPostDTO create() {
            return new CheckInPostDTO(this);
        }
    }
}
