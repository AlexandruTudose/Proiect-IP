package com.fiivirtualcatalog.modules.checkin.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassTypeTest {

    @Test
    public void customTestForVerifyingThings() {
        ClassType.valueOf(ClassType.Seminar.toString());
        ClassType.valueOf(ClassType.Laboratory.toString());
        ClassType.valueOf(ClassType.Course.toString());
    }

    @Test
    public void forAnInputStringSeminarShouldReturnSeminar() {
        assertEquals(ClassType.toEnum("Seminar"), ClassType.Seminar);
    }

    @Test
    public void forAnInputStringLaboratoryShouldReturnLaboratory() {
        assertEquals(ClassType.toEnum("Laboratory"), ClassType.Laboratory);
    }

    @Test
    public void forAnInputStringCourseShouldReturnCourse() {
        assertEquals(ClassType.toEnum("Course"), ClassType.Course);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forAnInputStringAnythingShouldReturnIllegalError() {
        assertEquals(ClassType.toEnum("Anything"), ClassType.Course);
    }
}