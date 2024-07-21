package com.coderscamp.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.coderscamp.students.Students;

public class UserService {
	
	private Students[] stuList = new Students[101];
	
	public UserService() throws FileNotFoundException, IOException {
		
		generateStudents();
		
	}

	private void generateStudents() throws FileNotFoundException, IOException {
		FileService fileService = new FileService();
		stuList = fileService.readMasterList();
		
	}
	
	

}
