package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void stringvalue()
	{
		SoftAssert sa = new SoftAssert();	
	System.out.println("a");
	System.out.println("b");
	sa.assertNotSame("aa", "bb", "notsame");
	System.out.println("c");
	sa.assertAll();
	}

	
}
