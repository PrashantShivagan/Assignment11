package com.cg.assignment;

import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException{
		Employee emp = new Employee("ABC", 10000 , 20, "S7");
		EmployeeServiceImpl es=new EmployeeServiceImpl();
		es.writeEmployeeToFile(emp);
	}
	
	
}
