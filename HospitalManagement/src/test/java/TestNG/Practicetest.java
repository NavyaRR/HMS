package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Practicetest {

		@Test(priority=0)
		public void deletetest()
		{
			System.out.println("delete test");
			Reporter.log("--delete--",true);
			
		}
	@Test(priority=-1)
		public void createtest()
		{
			System.out.println("create test");
		}
	@Test
		public void edittest()
		{
			System.out.println("edit test");

		}

	}
