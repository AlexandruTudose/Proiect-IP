package com.fiivirtualcatalog.modules.checkin.dtos;

import java.io.Serializable;

/**
 * Created by Alexandru on 6/14/2017.
 */
public class CheckInRegisterPostDTO implements Serializable {
    private long userId;
    private long checkInId;

    public CheckInRegisterPostDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(long checkInId) {
        this.checkInId = checkInId;
    }
}
