package com.coderscamp.service;

import java.util.Comparator;

import com.coderscamp.students.Student;

public class GradeSortComparator implements Comparator<Student> {

	@Override
	public int compare(Student grade1, Student grade2) {
		return grade2.getGrade().compareTo(grade1.getGrade());
	}

}
