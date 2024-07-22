package com.factory;

import com.DAO.IStudentDao;

import com.DAO.IStudentDaoImpl;

public class StudentDaoFactory {
private static IStudentDao stuDao;
private StudentDaoFactory() {
	
}
public static IStudentDao getStudentDao() {
	if(stuDao==null) {
		stuDao=new IStudentDaoImpl();
	}
	return stuDao;
}
}
