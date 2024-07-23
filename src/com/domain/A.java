package com.domain;

import java.sql.*;
import java.util.ArrayList;

public class A 
{
	private String url = "jdbc:mysql://localhost:3306/palle";
	private String username = "root";
	private String password = "sadhu";
	
	public void creating() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement s = con.createStatement();
			
			s.executeUpdate("CREATE TABLE EMP(ENO INT PRIMARY KEY AUTO_INCREMENT,ENAME VARCHAR(50) NOT NULL,ESALALRY INT NOT NULL)");
			
			s.close();
			con.close();
	    } 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void Inserting(String ename, int esalary) 
	{
		// By using PreparedStatement class
		try 
		{
			// Step 1:Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2: Establish the connection to database
			Connection con = DriverManager.getConnection(url,username,password);
			
			// Step 3: Prepare PreparedStatement
			PreparedStatement ps = con.prepareStatement("insert into emp(ename,esalary) values(?,?)");
			
			// Step 4: Insert input values in preparedstatement
			ps.setString(1, ename);
			ps.setInt(2, esalary);
			
			//Execute the Qurey or statement
			ps.executeUpdate();
			
			//close connection and preparedStatement
			ps.close();
			con.close();
	    } 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}
	
	public void updating(int eno,String ename,int esalary) 
	{
		PreparedStatement ps = null;
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
		    ps = con.prepareStatement("update emp set ename = ?,esalary =? where eno = ?");
			
			ps.setString(1, ename);
			ps.setInt(2, esalary);
			ps.setInt(3, eno);
			
			ps.executeUpdate();
			
		
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps != null) 
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
			
			if(ps != null) 
			{
				try
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleting(int eno) 
	{
		PreparedStatement ps = null;
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
		    ps = con.prepareStatement("delete from emp where eno = ?");
			
		
			ps.setInt(1, eno);
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(ps != null) 
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
			
			if(ps != null) 
			{
				try
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Employee> selecting() 
	{
		Connection con = null;
		Statement s = null;
		ArrayList<Employee> al = new ArrayList<Employee>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
		    s = con.createStatement();
			
			ResultSet rs = s.executeQuery("select*from emp");
			
			while(rs.next()) 
			{
				
				int no = rs.getInt("eno");
				String name = rs.getString("ename");
			    int salary = rs.getInt("esalary");
				
				Employee e = new Employee(no,name,salary);
				
				al.add(e);
			}
			
	    } 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				s.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return al;
	}
}
