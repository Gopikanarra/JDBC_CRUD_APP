package com.factory;

import com.service.IStudentService;
import com.service.IStudentServiceImpl;

public class StudentServiceFactory {
	private static IStudentServiceImpl studentServiceImpl;
	private StudentServiceFactory() {
		
	}
	public static IStudentService getStudentService() {
		if(studentServiceImpl==null)
			studentServiceImpl=new IStudentServiceImpl();
	
	return studentServiceImpl;
	}
}
