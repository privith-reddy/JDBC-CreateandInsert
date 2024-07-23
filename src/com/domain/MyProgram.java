package com.domain;

import java.util.ArrayList;

public class MyProgram 
{

	public static void main(String[] args) 
	{
		A a = new A();
		
		//a.creating();
		
//		a.Inserting("Privith", 50000);
//		a.Inserting("Shiva", 30000);
//	    a.Inserting("Sai", 20000);
//	    a.Inserting("Sathya", 25000);
		
//		a.Inserting("Vamsi", 15000);
//		a.Inserting("Karthik",10000);

		//a.updating(3,"Vinay", 75000);
		
		//a.deleting(6);
		
		ArrayList<Employee> alemp = a.selecting();
		
		for(Employee item : alemp) 
		{
			System.out.println(item.getEno());
			System.out.println(item.getEanme());
			System.out.println(item.getEsalary());
			
		}
		
		
		
	}

}
