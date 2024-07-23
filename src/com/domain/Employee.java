package com.domain;

public class Employee 
{
	private int eno;
	private String ename;
	private int esalary;
	
	
	
	public int getEno() 
	{
		return eno;
	}
	public void setEno(int eno) 
	{
		this.eno = eno;
	}
	public String getEanme()
	{
		return ename;
	}
	public void setEname(String ename) 
	{
		this.ename = ename;
	}
	public int getEsalary()
	{
		return esalary;
	}
	public void setEsalary(int esalary) 
	{
		this.esalary = esalary;
	}



	public Employee(int eno, String ename, int esalary) 
	{
		super();
		this.eno = eno;
		this.ename = ename;
		this.esalary = esalary;
	}
	
	

}
