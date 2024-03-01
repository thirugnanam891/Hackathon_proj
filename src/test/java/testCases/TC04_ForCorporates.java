package testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Health;
import testBase.BaseClass;

public class TC04_ForCorporates extends BaseClass {
	@Test(priority=1,groups= {"regression"})
	public void TC01_Corporate(){ 
		logger.info("************Starting TC004 TestCases************");
		heal=new Health(driver);
		
		heal.selectCorporate();
		logger.info("Navigate to For Corporates DropDown");
		heal.selectHealth();
		logger.info("Selecting Health and wellness plan");
	}
	@Test(priority=2,groups= {"sanity"})
	public void TC02_ScrollDown() {
		
		heal.scrollDown();
		logger.info("Scrolling down");
	}
	@Test(priority=3,groups= {"regression"})
	public void TC03_Details() throws InterruptedException {
		heal.enterDetails();
		logger.info("Fetched basic details like name,contact,email etc");
	}
	@Test(priority=4,groups= {"sanity"})
	public void TC04_Message() throws IOException, InterruptedException {
		heal.textPrint();
		logger.info("printing Thank you Message");
		heal.paraPrint();
		logger.info("printing Details of Message");
		heal.thankyou();
		logger.info("Thankyou Message Verified");
	
	
		logger.info("ScreenShot taken");
		logger.info("************Ending TC004 TestCases************");
	}

}
