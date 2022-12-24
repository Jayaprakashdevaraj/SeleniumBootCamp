package day1;

import org.testng.annotations.DataProvider;

public class inputDataProvider {

	
	@DataProvider(name = "createData")
	public Object[][] createNew() {
		return new Object[][] {
			{"salesforce by jp", "12/04/2022"}
			
		};
	}
}
