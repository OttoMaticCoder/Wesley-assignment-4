package com.coderscamp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
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
			
			System.out.println(Arrays.toString(stuList));
			return stuList;
			
		}
		
	}
	
	public void writeToFile() throws IOException {
			BufferedWriter writer = null;
					
					try {
						writer = new BufferedWriter(new FileWriter("data.txt"));
						writer.write("This is a test string that will be output into a file.\n");
						writer.write("Is this line of text on a new line?");
					} finally {
						if (writer != null) writer.close();
					}
	}
	
}
