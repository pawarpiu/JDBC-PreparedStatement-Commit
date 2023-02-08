package com.jsp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.dao.TeacherDao;
import com.jsp.dto.Teacher;

public class TestBatch {

	public static void main(String[] args) throws SQLException {
		TeacherDao td = new TeacherDao();
		ArrayList<Teacher> al = new ArrayList<>();
		Teacher t1 = new Teacher();
		t1.setId(7);
		t1.setName("");
		t1.setEmail("");
		t1.setCno(1122334455L);

		Teacher t2 = new Teacher();
		t2.setId(8);
		t2.setName("");
		t2.setEmail("");
		t2.setCno(1122334455L);

		Teacher t3 = new Teacher();
		t3.setId(9);
		t3.setName("");
		t3.setEmail("");
		t3.setCno(1122334455L);

		al.add(t1);
		al.add(t2);
		al.add(t3);
		td.addMulipleTeachers(al);
	}
}
