package com.genericUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DatabaseUtility {
	Connection con = null;

	public void connectToDB() throws SQLException
	{
		
		//step1: Register database
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
		//step2: get connection for database
			con = DriverManager.getConnection(IpathConstant.DBURL,IpathConstant.DBusername , IpathConstant.DBpassword);
	}
			
		public void executeAndgetData(String query, int colIndex, String expData) throws SQLException
		{
	    //step3: create statement
         Statement state = con.createStatement()  ;
           
			//step4: Execute query
         ResultSet result = state.executeQuery(query);
         boolean flag = false;
         while(result.next())
         {
        	 
        	String actual = result.getString(colIndex);
        	 if(actual.contains(expData))
        	 {
        		 flag = true;
        		 break;
        	 }
        	 
         }
         if(flag==true)
         {
        	 System.out.println("data is verified");
         }
         else
         {
        	 System.out.println("data is not present");
         }
       //step5: close database
		}
		public void closeDB() throws SQLException
		{
 		con.close();
 	     
		}
		

	
}

