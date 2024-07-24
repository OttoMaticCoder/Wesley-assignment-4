package com.coderscamp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;

import com.coderscamp.students.Students;

public class FileService {
	
	public Students[] readMasterList() throws FileNotFoundException, IOException {
		
		try(BufferedReader fileReader = new BufferedReader(new FileReader("student-master-list.csv"));) {
			fileReader.readLine();
			fileReader.skip(1);
			Students[] stuList = new Students[101];
			String line;
			int i = 0;
			
			
			
			while((line = fileReader.readLine()) != null) {
				
				
			String[] stuData = line.split(",");
			
				String studentId = stuData[0];
				String stuName = stuData[1];
				String course = stuData[2];
				String grade = stuData[3];
				
				Students student = new Students(studentId, stuName, course, grade);
				
				stuList[i] = student;
					i++;	
				
			}
			
			Arrays.sort(stuList, new Comparator<Students>() {

				@Override
				public int compare(Students course1, Students course2) {
					// if statements used to handle nulls initially, not needed after first sort.
					if(course1 == course2)
						return 0;
					if(course1 == null) {
						return 1;
					}
					if(course2 == null) {
						return -1;
					}
					return course1.getCourse().compareTo(course2.getCourse());
				}
			});
			
			System.out.println(Arrays.toString(stuList));
			
			Students[] apmthList = Arrays.copyOf(stuList, 33);
			Arrays.sort(apmthList, new GradeSortComparator());
				
			System.out.println(Arrays.toString(apmthList));
			
			Students[] compsciList = Arrays.copyOfRange(stuList, 33, 67);
			Arrays.sort(compsciList, new GradeSortComparator());
			System.out.println(Arrays.toString(compsciList));

			Students[] statList = Arrays.copyOfRange(stuList, 67, 100);
			Arrays.sort(statList, new GradeSortComparator());
			System.out.println(Arrays.toString(statList));
			
			
			
//			System.out.println(Arrays.toString(stuList));
			return stuList;
			
		}
		
	}
	
}
