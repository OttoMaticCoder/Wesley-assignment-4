package com.coderscamp.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Comparator;

import com.coderscamp.students.Student;

public class StudentService {
	
	private Student[] students;
	
	public StudentService(FileService fileService) {
		students = fileService.readMasterList();
	}
	
	public void sortStudents(Student[] students) {
		Arrays.sort(students, new GradeSortComparator());
	}
	
	public Student[] filterStudentsByCourse(String coursekey) {
		int studentCount = countStudentsInCourse(coursekey);
		Student[] courseStudents = new Student[studentCount];
		int counter = 0;
		for(Student student : students) {
			if(student.getCourse().contains(coursekey)) {
				courseStudents[counter++] = student;
			}
		}
		return courseStudents;
	}

	private int countStudentsInCourse(String coursekey) {
		int counter = 0;
		for(Student student : students) {
			if(student.getCourse().contains(coursekey)) {
				counter++;
			}
		}
		return counter; 
	}
}
	
	
