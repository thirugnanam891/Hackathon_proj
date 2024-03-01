package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class Doctors extends basePage {

	public Doctors(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static String file=System.getProperty("user.dir")+"/Test_data/hospital.xlsx";
	//selecting patient stories
	@FindBy(xpath="//span[@data-qa-id='doctor_review_count_selected']")
	WebElement patientStories;
	
	@FindBy(xpath="(//li[@role='option'])[3]")
	WebElement select1; //20+ patients
	
	//selecting doctor experience
	@FindBy(xpath="//span[@data-qa-id='years_of_experience_selected']")
	WebElement experience;
	
	@FindBy(xpath="(//li[@role='option'])[7]")
	WebElement select2; //10 years exp
	
	
	//selecting filter
	@FindBy(xpath="//i[@data-qa-id='all_filters_icon']")
	WebElement allFilter1; //clicking
	
	@FindBy(xpath="(//div[@data-qa-id='Fees_radio'])[1]")
	WebElement fees; //clicking 
	
	//@FindBy(xpath="//i[@data-qa-id='all_filters_icon']")
	//WebElement allFilter1; //clicking
	
	@FindBy(xpath="(//div[@data-qa-id='Availability_radio'])[3]")
	WebElement availability; //available tomorrow
	
	
	//selecting relevance
	@FindBy(xpath="//span[@data-qa-id='sort_by_selected']")
	WebElement relevance;
	
	@FindBy(xpath="//li[@role='option'][@data-qa-id='consultation_fees_desc']")
	WebElement select3; //choosing consultation fee
	
	//(//div[@class='info-section'])[1]
	
	@FindBy(xpath="//div[@class='info-section']")
	List<WebElement>  doctorProfile;
	
	
	
	
	
	//Action Methods
	
	public void selectingPatientStories() {
		patientStories.click();
	}
	
	public void selectPatientOpt() {
		select1.click();
		
	}
	public void selectDoctor() {
		experience.click();
	}
	public void selectDoctorExp() {
		select2.click();
	
	}
	public void selectFilter() {
		allFilter1.click();
	}
	public void selectFee() {
		fees.click();
	}
	public void selectFilterAgain() {
		allFilter1.click();
	}
	
	public void selectAvailableSlot() {
		availability.click();
	}
	public void selectRelevance() {
		relevance.click();
	}
	public void selectFeesDesc() {
		select3.click();
	}
	
	public void getDoctorInfo() throws IOException {
		int count=1;
		String details;
		for(WebElement firstFive:doctorProfile) {
			
			details=firstFive.getText();	
			ExcelUtils.setCellData(file,"Sheet2", count, 0, details);
			ExcelUtils.fillGreenColor(file, "Sheet2", 0, 0);
			System.out.println(details);
			System.out.println("**************************************************");
			
			if(count>=5) {
				break;
			}
			count++;
	}
	
	}
	
}
