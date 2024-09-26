package com.coderscamp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import com.coderscamp.students.Student;

public class FileService {
	
	private String FILENAME = "student-master-list.csv";
	
	public Student[] readMasterList()  {
		try(BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME));) {
			fileReader.readLine();
			Student[] stuList = new Student[100];
			String line;
			int stuCount = 0;

			while((line = fileReader.readLine()) != null) {
				
				String[] stuData = line.split(",");
			
				String studentId = stuData[0];
				String stuName = stuData[1];
				String course = stuData[2];
				String grade = stuData[3];
				
				Student student = new Student(studentId, stuName, course, grade);
		
				stuList[stuCount] = student;
				stuCount++;
			}
			return stuList;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void writer(Student[] stuList, String targetFilename) {
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilename));) {
						writer.write("Student ID, StudentName, Course, Grade \n");
						for(Student student : stuList) {
							writer.write(student.toString() + "\n");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
	}
	
}
