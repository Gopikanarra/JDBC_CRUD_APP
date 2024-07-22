package com.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.Student;
import com.util.JdbcUtil;

public class IStudentDaoImpl implements IStudentDao{
	Connection connection=null;
	PreparedStatement prepareStatement=null;
	private String status;
	static int rowsAffected=0;
	Student student=null;
	@Override
	public String save(Student student) {
		String query="insert into student(s_id,s_name,s_dept) values(?,?,?)";
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null) 
			prepareStatement=connection.prepareStatement(query);
			if(prepareStatement!=null) {
				prepareStatement.setInt(1,student.getSid());
				prepareStatement.setString(2,student.getName());
				prepareStatement.setString(3,student.getDept());

			}
			if(prepareStatement!=null) {
				 rowsAffected=prepareStatement.executeUpdate();
				if(rowsAffected==1) 
					status="success";
				else
					status="Failure";
			}
			else {
				status="Record not Available";
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Implementation class object ::"+connection.getClass().getName());
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		String query="select s_id,s_name,s_dept from student where s_id=?";
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
				prepareStatement=connection.prepareStatement(query);
			if(prepareStatement!=null) {
				prepareStatement.setInt(1,sid);
				ResultSet rs=prepareStatement.executeQuery();
				if(rs.next()) {
					student=new Student();
					student.setSid(rs.getInt(1));
					student.setName(rs.getString(2));
					student.setDept(rs.getString(3));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateById(Student student) {	
		String query="update student set s_name=?,s_dept=? where s_id=?";
		prepareStatement=null;
		String status=null;
		try {
			connection=JdbcUtil.getJdbcConnection();
		if(connection!=null) {
			prepareStatement=connection.prepareStatement(query);
			
		}
		if(prepareStatement!=null) {
			prepareStatement.setString(1, student.getName());
			prepareStatement.setString(2, student.getDept());
			prepareStatement.setInt(3, student.getSid());
		}
			if (prepareStatement != null) {
				int rowAffected = prepareStatement.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		}
		 catch (SQLException | IOException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		String query="DELETE FROM student WHERE s_id =?";
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
				prepareStatement=connection.prepareStatement(query);
			if(prepareStatement!=null)
				prepareStatement.setInt(1,sid);
				rowsAffected=prepareStatement.executeUpdate();
				if(rowsAffected==1)
					status="success";
				else
					status="Failure";
		}catch(SQLException  | IOException e) {
			e.printStackTrace();
		}
		return status;
	}

}
