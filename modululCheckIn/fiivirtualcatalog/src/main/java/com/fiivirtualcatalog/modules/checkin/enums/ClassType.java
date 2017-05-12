package com.fiivirtualcatalog.modules.checkin.enums;

public enum ClassType {
	Seminar, Laboratory, Course;
	
	public static ClassType toEnum(String classType){
		switch(classType){
		case "Seminar": return ClassType.Seminar;
		case "Laboratory": return ClassType.Laboratory;
		case "Course": return ClassType.Course;
		default: throw new IllegalArgumentException();
		}
	}
	
	@Override
	public String toString(){
		if(this == Seminar){
			return "Seminar";
		}
		if(this == Laboratory){
			return "Laboratory";
		}
		return "Course";
	}
}
