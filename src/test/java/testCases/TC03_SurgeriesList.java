package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Surgeries;
import testBase.BaseClass;

public class TC03_SurgeriesList extends BaseClass{
	@Test(priority=1,groups= {"regression"})
	public void TC01_Surgery() throws InterruptedException, IOException {
		logger.info("************Starting TC003 TestCases************");
		sur=new Surgeries(driver);
		
		sur.clickSurgery();
		//Thread.sleep(1000);
		logger.info("Navigating to Surgeries page");
	}
	@Test(priority=2,groups= {"sanity"})
	public void TC02_Scroll() {
		sur.scrollDown();
		logger.info("Scrolling down to Popular Surgeries");
		//Thread.sleep(1000);
	}
	@Test(priority=3,groups= {"regression"})
	public void SurgeryList() throws IOException {
		sur.listOfSurgeries();
		logger.info("Fetching List of Surgeries");
		logger.info("************Ending TC003 TestCases************");
		
	}
}
