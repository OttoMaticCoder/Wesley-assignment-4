package com.coderscamp.mainapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.coderscamp.service.FileService;

public class GradeAndClassOrganizerApp {
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		 
		
		Scanner scanner = new Scanner(System.in);
		FileService fileService =  new FileService();		
		fileService.readMasterList();
		
		
		
		
		
		
		
	}

}
