package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Doctors;
import pageObjects.Surgeries;
import testBase.BaseClass;

public class TC02_DoctorPage extends BaseClass {
	@Test(priority=1,groups= {"regression"})
	public void TC001_PatientStory() throws InterruptedException, IOException {
		logger.info("*************Starting TC002 TestCases************");
		doctor=new Doctors(driver);
		doctor.selectingPatientStories();
		logger.info("Clicking patient Stories");
		Thread.sleep(1000);
		doctor.selectPatientOpt();
		logger.info("Clicking patient Stories");
		Thread.sleep(1000);
	}
	@Test(priority=2,groups= {"regression"})
	public void TC002_DoctorExp() throws InterruptedException {
		doctor.selectDoctor();
		logger.info("Clicking patient Stories");
		Thread.sleep(1000);
		
		doctor.selectDoctorExp();
		logger.info("Clicking patient Stories");
		Thread.sleep(1000);
	}
	@Test(priority=3,groups= {"regression"})
	public void TC003_FilterSelect() throws InterruptedException {
		doctor.selectFilter();
		logger.info("Clicking patient Stories");
		Thread.sleep(1000);
		
		doctor.selectFee();
		logger.info("Clicking patient Stories");
		Thread.sleep(1000);
		
		doctor.selectFilterAgain();
		logger.info("Clicking patient Stories");
		Thread.sleep(2000);
	
		doctor.selectAvailableSlot();
		logger.info("Clicking availabilty");
		Thread.sleep(1000);
	}
	@Test(priority=4,groups= {"sanity"})
	public void TC004_Relevance() throws InterruptedException {
		doctor.selectRelevance();
		logger.info("Clicking Relevance DropDown");
		Thread.sleep(1000);
		
		doctor.selectFeesDesc();
		logger.info("Selecting Fee Description");
		Thread.sleep(1000);
	}
	@Test(priority=5,groups= {"regression"})
	public void TC005_Doctor() throws IOException {
		doctor.getDoctorInfo();
		logger.info("Extracting Doctors information");
		logger.info("************Ending TC002 TestCases************");
		
	}


}
