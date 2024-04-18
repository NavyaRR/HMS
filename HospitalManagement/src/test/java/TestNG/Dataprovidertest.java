package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovidertest {
	@Test(dataProvider = "data")
	public void getdata(String org,String loc)
	{
		System.out.println("organization--->"+org+" is located in "+loc);
	}
	
	@DataProvider
	public Object[][] data()
	{
		 Object[][] obj = new Object[2][2];
		 obj[0][0]="qspider";
		 obj[0][1]="bangalore";
		 
		 obj[1][0]="jspiders";
		 obj[1][1]="mysore";
		 return obj;	
	}

	

	}


