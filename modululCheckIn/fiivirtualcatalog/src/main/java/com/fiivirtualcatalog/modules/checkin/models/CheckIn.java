package com.fiivirtualcatalog.modules.checkin.models;

import com.fiivirtualcatalog.modules.user.models.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "check_ins")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "subject")
    private String subject;

    @NotNull
    @Column(name = "class_type")
    private String classType;

    @NotNull
    @Column(name = "number_of_users")
    private long numberOfCheckedInUsers;

    @Column(name = "finishing_flag")
    private boolean finishingFlag;
    
    @Column(name = "code")
    private String code;

    @ManyToMany
    @JoinTable(name = "users_check_ins", joinColumns = {@JoinColumn(name = "check_in_id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id")}, uniqueConstraints = {
            @UniqueConstraint(columnNames = {"check_in_id", "user_id"})})
    private List<User> checkedInUsers;

    public CheckIn() {
        this.numberOfCheckedInUsers = 0;
        this.finishingFlag = false;
        this.checkedInUsers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public long getNumberOfCheckedInUsers() {
        return numberOfCheckedInUsers;
    }

    public void setNumberOfCheckedInUsers(long numberOfCheckedInUsers) {
        this.numberOfCheckedInUsers = numberOfCheckedInUsers;
    }

    public boolean getFinishingFlag() {
        return this.finishingFlag;
    }

    public void setFinishingFlag(boolean finishingFlag) {
        this.finishingFlag = finishingFlag;
    }

    public List<User> getCheckedInUsers() {
        return checkedInUsers;
    }

    public void setCheckedInUsers(List<User> checkedInUsers) {
        this.checkedInUsers = checkedInUsers;
    }

    public void addToCheckedInUsers(User user) {
        this.checkedInUsers.add(user);
        this.setNumberOfCheckedInUsers(this.getCheckedInUsers().size());
    }

    private CheckIn(Builder builder) {
        this.setUser(builder.user);
        this.setSubject(builder.subject);
        this.setClassType(builder.classType);
        this.setNumberOfCheckedInUsers(0);
        this.setFinishingFlag(false);
        this.setCheckedInUsers(new ArrayList<>());
    }

    public static class Builder {
        private User user;
        private String subject;
        private String classType;

        public Builder() {
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder classType(String classType) {
            this.classType = classType;
            return this;
        }

        public CheckIn create() {
            return new CheckIn(this);
        }
    }
}
