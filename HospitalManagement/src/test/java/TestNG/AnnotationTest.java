package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest {

@BeforeSuite
public void db()
{
System.out.println("connect");
}


@BeforeClass
public void browser()
{
	System.out.println("launch");
}


@BeforeMethod
public void Log()
{
	System.out.println("login");
}


@Test
public void admin()
{
	System.out.println("admin");
}


@AfterMethod
public void Logout()
{
	System.out.println("logout");
}

@AfterClass
public void cbrowser()
{
	System.out.println("closebro");
}

@AfterSuite
public void db1()
{
	System.out.println("close db");
	
}


}
