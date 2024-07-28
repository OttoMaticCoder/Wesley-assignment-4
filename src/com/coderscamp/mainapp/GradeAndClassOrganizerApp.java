package com.coderscamp.mainapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.coderscamp.service.GradeSortComparator;
import com.coderscamp.service.FileService;
import com.coderscamp.students.Students;

public class GradeAndClassOrganizerApp {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileService fileService =  new FileService();		
		Students[] stuList = fileService.readMasterList();
		
		
		// Sorting array and creating individual lists
		Arrays.sort(stuList, new Comparator<Students>() {
				@Override
				public int compare(Students course1, Students course2) {
				return course1.getCourse().compareTo(course2.getCourse());
			}});
//								System.out.println(Arrays.toString(stuList));
		
								
		Students[] apmthList = Arrays.copyOf(stuList, 33);
		Arrays.sort(apmthList, new GradeSortComparator());
//		System.out.println(Arrays.toString(apmthList));
		
		Students[] compsciList = Arrays.copyOfRange(stuList, 33, 67);
		Arrays.sort(compsciList, new GradeSortComparator());
//		System.out.println(Arrays.toString(compsciList));

		Students[] statList = Arrays.copyOfRange(stuList, 67, 100);
		Arrays.sort(statList, new GradeSortComparator());
//		System.out.println(Arrays.toString(statList));
		
		fileService.writer("course1.csv", compsciList);
		fileService.writer("course2.csv", apmthList);
		fileService.writer("course3.csv", statList);

	}
}
