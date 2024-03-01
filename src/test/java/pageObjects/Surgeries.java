package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class Surgeries extends basePage {

	public Surgeries(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	static String file=System.getProperty("user.dir")+"/Test_data/hospital.xlsx";
	
	
	
	@FindBy(xpath="//a[@event='Nav:Interacted:Surgery']")
	WebElement surgery;
	
	@FindBy(xpath="//h1[@data-qa-id='surgical-solution-sub-header']")
	WebElement navigate; //js executor
	
	@FindBy(xpath="//div[@class='flex flex-wrap gap-y-44px pb-40px SurgicalSolutions-module_surgeriesList__1gl-I']/div")
	List<WebElement> popularSurgery;
	//By poupularSurgery=By.xpath("//div[@class='flex flex-wrap gap-y-44px pb-40px SurgicalSolutions-module_surgeriesList__1gl-I']/div");
	
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	
	//Action Methods
	public void clickSurgery() {
		surgery.click();
	}
	public void scrollDown() {
		js.executeScript("arguments[0].scrollIntoView();", navigate);
		
	}
	public void listOfSurgeries() throws IOException  {
		
		
//			List<WebElement> sur=driver.findElements(poupularSurgery);
//			for(int i=0;i<sur.size();i++) {
//				String h=driver.findElement((By.xpath("(//p[@class='mt-12px AilmentItem-module_itemText__XvCHL'])["+i+"]"))).getText();
//			
//			ExcelUtils.setCellData(file, "Sheet2", i, 1, h);
			int row=1;
			for(WebElement allSurgery:popularSurgery) {
				String surgeries=allSurgery.getText();
				ExcelUtils.setCellData(file, "Sheet3", row, 0, surgeries);
				System.out.println(surgeries);
				row++;
		}
		System.out.println("***********************************************");
	}
	
	
}
