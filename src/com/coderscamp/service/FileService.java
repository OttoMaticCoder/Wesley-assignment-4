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
			Students[] stuList = new Students[101];
			String line;
			int i = 0;
			
			while((line = fileReader.readLine()) != null) {
			String[] stuData = line.split(",");
				
//				String studentId = stuData[0];
				String stuName = stuData[1];
				String course = stuData[2];
				String grade = stuData[3];
				
				Students student = new Students(stuName, course, grade);
				
				stuList[i] = student;
					i++;	
				
			}
			
			Arrays.sort(stuList, new Comparator<Students>() {

				@Override
				public int compare(Students alpha1, Students alpha2) {
					return alpha1.getCourse().compareTo(alpha2.getCourse());
				}
			});
			
			try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("coures1.csv"));) {
				fileWriter.write(stuList.length);
				
				
				
			}
			
			
			
			
			System.out.println(Arrays.toString(stuList));
			return stuList;
			
		}
		
		
		
	}

}
