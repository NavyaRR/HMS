package com.genericUtility;

		import java.io.FileInputStream;
		import java.io.IOException;
		import java.util.Properties;

		public class FileUtility {
		/**
		 * this method is used for reading data from property file
		 * @author navy
		 * @param key
		 * @return
		 * @throws IOException
		 */
			public String readDataFromPropertyFile(String key) throws IOException
			{
				FileInputStream fis= new FileInputStream(IpathConstant.FilePath);
				// ipathconstant is an interface, call the path/variable name using that interface
				Properties pObj = new Properties();
				pObj.load(fis);
				
				String value =pObj.getProperty(key);
				
				return  value;
				
			
	}

}
