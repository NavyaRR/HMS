package TestNG;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderusingdiffclass {
@Test(dataProviderClass = Dataprovidertest.class ,dataProvider = "data")
public void getread(String name,String name1)
{
	Reporter.log(name);
	Reporter.log(name1);
}
	}


