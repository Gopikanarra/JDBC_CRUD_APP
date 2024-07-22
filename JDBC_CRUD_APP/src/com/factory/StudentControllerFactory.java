package com.factory;

import com.controller.IStudentController;
import com.controller.StudentControllerImpl;

public class StudentControllerFactory {
	private static IStudentController studentController;
	
	private StudentControllerFactory() {
		
	}
	
	public static IStudentController getStudentController() {
		
		if(studentController ==null) {
		studentController=new StudentControllerImpl();
		
	}
		return studentController;
	}
}
