package com.service;

import com.DAO.IStudentDao;
import com.DTO.Student;
import com.factory.StudentDaoFactory;

public class IStudentServiceImpl implements IStudentService {
	IStudentDao studentDao;
	
	@Override
	public String save(Student student) {
		studentDao=StudentDaoFactory.getStudentDao();
		
		return studentDao.save(student);
	
	}

	@Override
	public Student findById(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		
		return studentDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sid);
	}

	

}
