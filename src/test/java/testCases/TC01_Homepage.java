package testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import pageObjects.Doctors;
import pageObjects.Health;
import pageObjects.HomePage;
import pageObjects.Surgeries;
import testBase.BaseClass;

public class TC01_Homepage extends BaseClass {
	
	@Test(priority=1,groups= {"sanity"})
	public void TC001_Location() throws InterruptedException, IOException {
		logger.info("*******Starting the TC001 TestCases********" );
		home=new HomePage(driver);
		//Thread.sleep(1000);
		home.clickLoc();
		logger.info("******Clicking the location Text Box*******");
		home.clearLocation();
		logger.info("******Clearing the location Text Box*******");
		//Thread.sleep(1000);
		home.sendLocation();
		logger.info("******Sending Location******");
		Thread.sleep(1000);
		
	}
	@Test(priority=2,groups= {"regression"})
	public void TC002_DropOption() {
		home.selectDropOpt();
		//Thread.sleep(1000);
		logger.info("*****Selecting Current Location******");
	}
	@Test(priority=3,groups= {"sanity"})
	public void TC003_DoctorSearch()	{
		home.searchingDoctor();
		//Thread.sleep(1000);
		logger.info("*****Search Doctor type******");
	}
	@Test(priority=4,groups= {"regression"})
	public void TC004_SendDoctor() throws IOException {
		home.sendDoctor();
		logger.info("****Sending preffered doctor******");
		
		//logger.info( driver, doctor);
	}
	@Test(priority=5,groups= {"regression"})
	public void TC005_DoctorSelect() throws InterruptedException {
		Thread.sleep(1000);
		home.selectDoctor();
		logger.info("*****Selecting doctor*******");
	logger.info("*************Ending the TC001 TestCases************");
	}
	
}	
	
	 
	



