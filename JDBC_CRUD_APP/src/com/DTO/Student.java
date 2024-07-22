package com.DTO;

public class Student {
	private int sid;
	private String name;
	private String dept;

	
	
	public Student() {
		System.out.println("Student Object Created...!!!");
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	


	


	public int getSid() {
		return sid;
	}


	public void setSid(int i) {
		this.sid = i;
	}
	
	@Override
	public String toString() {
		
		return "Student[name="+name+",dept="+dept+",id="+sid+"]";
	}
}
