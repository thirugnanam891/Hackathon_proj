package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;



public class HomePage extends basePage {
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//input[@placeholder='Search location']")
	WebElement clickLoc;
	@FindBy(xpath="//input[@placeholder='Search location']")
	WebElement clrLoc;
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement sendLoc;
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-city']")
	WebElement dropOpt;
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement searchDoctor;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement sendDoctor;
	
	@FindBy(xpath="(//div[@data-qa-id='omni-suggestion-main'])[1]")
	WebElement clickDoctor;
	
	String []inputData= ExcelUtils.read();
	
	
	//Action Methods
	public void clickLoc() {
		clickLoc.click();
	}
	
	public void clearLocation() {
		clrLoc.clear();
	}
	public void sendLocation() throws IOException {
		
		 
		sendLoc.sendKeys(inputData[0]);
	}
	
	public void selectDropOpt() {
		dropOpt.click();
	}
	public void searchingDoctor() {
		searchDoctor.click();
	}
	
	public void sendDoctor() throws IOException {
		sendDoctor.sendKeys(inputData[1]);
	}
	public void selectDoctor() {
		clickDoctor.click();
	}
}
