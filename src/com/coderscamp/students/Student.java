package com.coderscamp.students;

public class Student {
	
	String studentId;
	String name;
	String course;
	String grade;
	
	public Student(String studentId, String name, String course, String grade) {
		
		this.studentId = studentId;
		this.name = name;
		this.course = course;
		this.grade = grade;
		
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	 @Override
		public String toString()
		{
		        return this.studentId + "," + this.name + "," + this.course + "," + this.grade;
		}
}
