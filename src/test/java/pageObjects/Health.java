package pageObjects;
 


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.ExcelUtils;
 
public class Health extends basePage {
 
	public Health(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	static String file=System.getProperty("user.dir")+"/Test_data/hospital.xlsx";
	
	@FindBy(xpath="//span[@class='nav-interact']")
	WebElement corporates;
	
	@FindBy(xpath="(//div[@class='u-d-item']/a)[1]")
	WebElement health;
	
	@FindBy(xpath="(//h2[@class='u-m-b--20 text-beta'])[1]")
	WebElement scrolltill;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement name;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement orgName;
	
	@FindBy(xpath="(//input[@type='tel'])[1]")
	WebElement contact;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement email;
	
	
	@FindBy(xpath="(//select[@class='corporate-form__select text-grey-3'])[1]") //click
	WebElement orgSize;
	
	@FindBy(xpath="//*[@id=\"organizationSize\"]/option[3]")
	WebElement clickOption;
	
	@FindBy(xpath="//select[@id='interestedIn'][1]") //click
	WebElement intrestedIn;
	
	@FindBy(xpath="(//option[@value='Taking a demo'])[1]")
	WebElement clickIntrest;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement verify;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement clear;
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement fill;
	@FindBy(xpath="(//button[@type='submit'])[2]") //header[@id='header']//button[normalize-space()='Schedule a demo']
	WebElement verifySubmit;
	@FindBy(xpath="(//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue'])[2]")
	WebElement clickSubmit;
	@FindBy(xpath="(//div[@class='u-text--bold text-alpha'])[1]")
	WebElement text;
	@FindBy(xpath="(//div[@class='u-m-t--10'])[1]")
	WebElement text2;
	
	
	//Action Methods
	String []inputData= ExcelUtils.read();
	
	
	public void selectCorporate() {
		corporates.click();
	}
	public void selectHealth() {
		health.click();
	}
	
	public void scrollDown() {
		js.executeScript("arguments[0].scrollIntoView();", scrolltill);
	}
	public void enterDetails() throws InterruptedException {
		name.sendKeys(inputData[2]);
	
		orgName.sendKeys(inputData[3]);
	
		contact.sendKeys(inputData[4]);
	
		email.sendKeys(inputData[5]);
		
		orgSize.click();
	
		clickOption.click();
	
		intrestedIn.click();
	
		clickIntrest.click();
		Thread.sleep(3000);
		Boolean bool=verify.isEnabled();
		if(bool==false) {
			System.out.println("Demo is disabled");
		}
		else {
			System.out.println("Test failes,Demo is enabled");
		}
		
		Thread.sleep(2000);
		email.clear();
		email.sendKeys(inputData[6]);
		Thread.sleep(3000);
		Boolean bool1=verifySubmit.isEnabled();
		if(bool1==true) {
			System.out.println("submit clicked");
		}
		else {
			System.out.println("Error");
		}
		verify.click();
		Thread.sleep(30000);
	}
	
	
		public void textPrint() throws IOException {
			String msg=text.getText();
			//ExcelUtils.setCellData(file,"Sheet2", 1, 3, msg);
			System.out.println(msg);
		}
		public void paraPrint() {
			String msg1=text2.getText();
			System.out.println(msg1);
		}
		
		public void thankyou() throws InterruptedException {
			//Thread.sleep(7000);
			Boolean thankyou = text.isDisplayed();
			Assert.assertTrue(thankyou,"THANK YOU message is not displayed" );
			System.out.println("THANK YOU message is displayed" );
			
		}
		

}

	
	
	
