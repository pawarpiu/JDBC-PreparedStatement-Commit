package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.Teacher;
import com.jsp.helper.HelperClass;

public class TeacherDao {
	HelperClass hc = new HelperClass();
	Connection c = null;

	public Teacher saveTeacher(Teacher t) throws SQLException {
		c = hc.getConnection();
		String ex = "insert into teacher values(?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(ex);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getEmail());
			ps.setLong(4, t.getCno());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.close();
		}
		return t;
	}

	public Teacher deleteTeacher(Teacher t) throws SQLException {
		c = hc.getConnection();
		String ex = "delete from teacher where id=?";
		try {
			PreparedStatement ps = c.prepareStatement(ex);
			ps.setInt(1, t.getId());
			int a = ps.executeUpdate();
			if (a > 0)
				System.out.println("deleted successfully");
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.close();
		}
		return t;
	}

	public Teacher updateTeacher(Teacher t) throws SQLException {
		c = hc.getConnection();
		String ex = "update teacher set email=? where id=?";
		try {
			PreparedStatement ps = c.prepareStatement(ex);
			ps.setString(1, t.getEmail());
			ps.setInt(2, t.getId());
			int a = ps.executeUpdate();
			if (a > 0)
				System.out.println("updated successfully");
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.close();
		}
		return t;
	}

	public List<Teacher> addMulipleTeachers(List<Teacher> t) throws SQLException {
		c = hc.getConnection();
		String ex = "insert into teacher values(?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(ex);
			for (Teacher t1 : t) {
				ps.setInt(1, t1.getId());
				ps.setString(2, t1.getName());
				ps.setString(3, t1.getEmail());
				ps.setLong(4, t1.getCno());

				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.close();
		}
		return t;
	}
}
