package com.univ.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.univ.bean.Course;
import com.univ.util.DBUtil;

public class CourseDAO {
	Course course=null;
	public Course findCourse(String courseID) {
		Connection connection=DBUtil.getDBConnection();
		String query="Select * from Course_tbl where Course_ID=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,courseID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				course=new Course();
				course.setCourseID(rs.getString("Course_ID"));
				course.setCourseTitle(rs.getString("Course_Title"));
				course.setCredits(rs.getInt("Credits"));
				course.setCapacity(rs.getInt("Capacity"));
				course.setEnrolledCount(rs.getInt("Enrolled_Count"));
			}
;		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	public List<Course> viewAllCourse(){
		List<Course> list=new ArrayList<>();
		Connection connection=DBUtil.getDBConnection();
		String query="Select * from Course_tbl";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Course c=new Course();
				c.setCourseID(rs.getString(1));
				c.setCourseTitle(rs.getString(2));
				c.setCredits(rs.getInt(3));
				c.setCapacity(rs.getInt(4));
				c.setEnrolledCount(rs.getInt(5));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean insertCourse(Course course) {
		Connection connection=DBUtil.getDBConnection();
		String query="insert into Course_tbl values(?,?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,course.getCourseID());
			ps.setString(2, course.getCourseTitle());
			ps.setInt(3, course.getCredits());
			ps.setInt(4, course.getCapacity());
			ps.setInt(5, course.getEnrolledCount());
			int rows=ps.executeUpdate();
			if(rows>0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateEnrolledCount(String courseID,int newCount) {
		Connection connection=DBUtil.getDBConnection();
		String query="update Course_tbl set Enrolled_Count=? where Course_ID=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,newCount);
			ps.setString(2, courseID);
			int rows = ps.executeUpdate();
			if(rows>0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteCourse(String courseID) {
		Connection connection=DBUtil.getDBConnection();
		String query="delete from Course_tbl  where Course_ID=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, courseID);
			int rows = ps.executeUpdate();
			if(rows>0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}










