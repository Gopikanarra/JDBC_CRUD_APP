package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.DTO.Student;
import com.controller.IStudentController;
import com.factory.StudentControllerFactory;

public class TestApp {

	static IStudentController studentController=StudentControllerFactory.getStudentController();
;
	static Student studentRecord; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1.CREATE");
			System.out.println("2.READ");
			System.out.println("3.UPDATE");
			System.out.println("4.DELETE");
			System.out.println("5.EXIT");
			System.out.println("enter ur choice:[1,2,3,4,5]");
			Integer choice=Integer.parseInt(br.readLine());
			Integer id=0;
			String status=null;
			switch(choice) {
			case 1: 
				System.out.println("enter the name::");
				String name=br.readLine();
				System.out.println("enter the student id::");
				int sid=Integer.parseInt(br.readLine());
				System.out.println("enter the department::");
				String dept=br.readLine();
				
				Student student=new Student();
				student.setName(name);
				student.setSid(sid);
				student.setDept(dept);
				
				status=studentController.save(student);
				if(status.equalsIgnoreCase("success")) {
					System.out.println("Record inserted successfully!!");
				}else if(status.equalsIgnoreCase("failure")) {
					System.out.println("Record insertion failed..!!");
				}else {
					System.out.println("some error occured..!!");
				}
				
				break;
			case 2:
				System.out.println("please enter ur id:");
				id=Integer.parseInt(br.readLine());
			
				studentRecord=studentController.findById(id);
				if(studentRecord!=null)
					System.out.println(studentRecord);
				else
					System.out.println("record not available for the given id::"+id);
				break;
				
			case 3:
				System.out.println("enter the id to update");
				id=Integer.parseInt(br.readLine());
				studentRecord=studentController.findById(id);
				
				if(studentRecord!=null) {
					Student new_student=new Student();
					new_student.setSid(id);
					System.out.println("student name [old name is:"+studentRecord.getName()+"]");
					String newName=br.readLine();
					if(newName==null|| newName.equals("")) {
						new_student.setName(studentRecord.getName());
					}else {
						new_student.setName(newName);
					}
					String newDept=br.readLine();
					if(newDept==null|| newDept.equals("")) {
						new_student.setName(studentRecord.getDept());
					}else {
						new_student.setDept(newDept);
					}
					status=studentController.updateById(new_student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record updated succesfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record updation failed...");
					} else {
						System.out.println("Some problem occured...");
					}

				}
				else
					System.out.println("record not found");
				break;
			
			case 4:
				System.out.println("please enter ur id:");
				id=Integer.parseInt(br.readLine());
				status=studentController.deleteById(id);
				if(status.equalsIgnoreCase("success")) {
					System.out.println("Record deleted successfully!!");
				}else if(status.equalsIgnoreCase("failure")) {
					System.out.println("Record deletion failed..!!");
				}else {
					System.out.println("Id not Available...!!");
				}
				
				break;
			
			case 5:
				System.out.println("exiting from the system");
				System.exit(0);
				
			
				default:
					System.out.println("please choose the valid choice..!!");
			}
		}
		
	
	}

}
