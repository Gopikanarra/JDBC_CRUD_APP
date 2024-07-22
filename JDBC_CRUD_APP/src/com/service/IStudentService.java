package com.service;

import com.DTO.Student;

public interface IStudentService {
	String save(Student student);// for create operation
	Student findById(Integer sid);//for reading purpose
	String updateById(Student student);//for updating student Record
	String deleteById(Integer sid);//Deleting a Student Record
	
}
