package com.DAO;

import com.DTO.Student;

public interface IStudentDao {
	String save(Student student);// for create operation
	Student findById(Integer sid);//for reading purpose
	String updateById(Student student);//for updating student Record
	String deleteById(Integer sid);//Deleting a Student Record
	}
