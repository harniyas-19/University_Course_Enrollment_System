package com.univ.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.univ.bean.Enrollment;
import com.univ.util.DBUtil;

public class EnrollmentDAO {
	Enrollment enroll=null;
	public int generateEnrollmentID() {
		int id=0;
		Connection connection=DBUtil.getDBConnection();
		String query="select NVL(Max(Enrollment_ID),50000)+1 from Enrollment_tbl1";
		try {
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	public boolean recordEnrollment(Enrollment enroll) {
		Connection connection=DBUtil.getDBConnection();
		String query="insert into Enrollment_tbl1 values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,enroll.getEnrollmentID());
			ps.setString(2, enroll.getCourseID());
			ps.setString(3, enroll.getStudentID());
			ps.setString(4, enroll.getStudentName());
			ps.setDate(5,new Date( enroll.getEnrollmentDate().getTime()));
			ps.setString(6,enroll.getStatus());
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
	public Enrollment findEnrollment(int id) throws Exception {
        Connection con = DBUtil.getDBConnection();
        String query = "SELECT * FROM Enrollment_tbl1 WHERE Enrollment_ID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Enrollment e = null;

        if (rs.next()) {
            e = new Enrollment();
            e.setEnrollmentID(rs.getInt("enrollment_id"));
            e.setCourseID(rs.getString("course_id"));
        }

        con.close();
        return e;
    }
	public boolean closeEnrollment(int enrollment) {
		Connection connection=DBUtil.getDBConnection();
		String query="update Enrollment_tbl1 set status='DROPPED' where Enrollment_ID=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, enrollment);
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
}
