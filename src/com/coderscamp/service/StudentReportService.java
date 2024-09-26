package com.coderscamp.service;

import com.coderscamp.students.Student;

public class StudentReportService {
	
	private FileService fileService;
	private StudentService studentService;
	
	public StudentReportService(FileService fileService, StudentService studentService) {
		this.fileService = fileService;
		this.studentService = studentService;
	}
	
	public void generateCourseStudentsReport(String courseKey, String reportFileame) {
		
		Student[] courseStudents = studentService.filterStudentsByCourse(courseKey);
		studentService.sortStudents(courseStudents);
		fileService.writer(courseStudents, reportFileame);
	}
}
