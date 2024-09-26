package com.coderscamp.mainapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.coderscamp.service.GradeSortComparator;
import com.coderscamp.service.StudentReportService;
import com.coderscamp.service.StudentService;
import com.coderscamp.service.FileService;
import com.coderscamp.students.Student;

public class GradeAndClassOrganizerApp {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileService fileService =  new FileService();
		StudentService studentService = new StudentService(fileService);
		
		StudentReportService reportService = new StudentReportService(fileService, studentService);
		reportService.generateCourseStudentsReport("COMPSCI", "course-1.csv");
		reportService.generateCourseStudentsReport("APMTH", "course-2.csv");
		reportService.generateCourseStudentsReport("STAT", "course-3.csv");
		
		System.out.println("Student reports complied for: \nCOMPSCI = course-1.csv\nAPMTH = course-2.csv\nSTAT = course-3.csv");

	}
} 
