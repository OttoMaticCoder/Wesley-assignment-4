package com.coderscamp.service;

import java.util.Comparator;

import com.coderscamp.students.Students;

public class GradeSortComparator implements Comparator<Students> {

	@Override
	public int compare(Students grade1, Students grade2) {
		return grade2.getGrade().compareTo(grade1.getGrade());
	}

}
