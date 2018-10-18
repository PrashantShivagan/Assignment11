package com.cg.assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class Employee {

  String name;
  double salary;
  Integer id;
  String Designation;
  public String InsuranceScheme;
  
  

  public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getDesignation() {
	return Designation;
}

public void setDesignation(String designation) {
	Designation = designation;
}

public String getInsuranceScheme() {
	return InsuranceScheme;
}

public void setInsuranceScheme(String insuranceScheme) {
	InsuranceScheme = insuranceScheme;
}

public Employee(String name, double salary, Integer id, String Designation) {
    //parameterized constructor
	  this.name = name;
	  this.salary = salary;
	  this.id = id;
	  this.Designation = Designation;
	  InsuranceScheme = getInsuranceScheme(salary);
  }

  public String getInsuranceScheme(double salary) {
	  if(salary >5000 && salary< 20000){
		  return "scheme c";
		  
	  }else if(salary>=20000 && salary<40000){
		  return "scheme b";
		  
	  }else if(salary >=40000){
		  return "scheme a";
		  
	  }else if(salary < 5000){
		  return "no scheme";
	  }else
		  return null;

    //write your code here to return the scheme on the basis of salary
    //if nothing falls in the range return null 
	  
  }
  public String toString(){
    return "Name: " + name + " Id: " + id + " Salary: " + salary + " Designation: " + Designation
        + " InsuranceScheme: " + InsuranceScheme;
  }
}


class EmployeeServiceImpl {
  //Declare a Hashmap here where key is an Integer and the value is Employee object
	public  Map<Integer,Employee> employee = new HashMap<Integer,Employee>();
  
	EmployeeServiceImpl(){
		
	}

  public void addEmployee(Employee emp) {
    //write your code here to add employee to the hashmap 
	  employee.put(emp.id, emp);
	  
    

  }

  public boolean deleteEmployee(int id){
    //write your code here for returning true if the employee deleted wrt the id passed else false
	  if(employee.equals(id)){
		  employee.remove(id);
		  return true;
	  }
	  else
	  {
		  return false;
	  }
	
	  
	  
	  
  
  }

  public String ShowEmpDetails(String InsuranceScheme) {
    //Write your code here to return a string i.e the employee details according to the insurance scheme
    //Format: Name: name Id: id Salary: salary Designation: Designation InsuranceScheme: InsuranceScheme
    //If multiple results they should be in a different line
	  	Collection<Employee> c = employee.values();
	  	String x = "";
	   for(Employee emp :  c){
		   if(emp.InsuranceScheme == InsuranceScheme){
			   x = x+ "Name: " + emp.name + " Id: " + emp.id + " Salary: " + emp.salary + " Designation: " + emp.Designation
			            + " InsuranceScheme: " + emp.InsuranceScheme + "/n";
		   }
	   }
	return x;
	  	


  }

  public void writeEmployeeToFile(Employee employee) throws IOException{
    //Write your code here 
    //make use of toString Method to write the employee details in the file
		FileWriter fir = null;
	  try {
	 fir = new FileWriter("output.txt");
		fir.write(employee.toString());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  fir.close();
  }

}

