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
		switch(this){
		case Seminar: return "Seminar";
		case Laboratory: return "Laboratory";
		case Course: return "Course";
		default: throw new IllegalArgumentException();
		}
	}
}
