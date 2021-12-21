package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class KitePinPage 
{
	@FindBy(id="pin") private WebElement PIN;
	@FindBy(xpath = "//button[@class='button-orange wide']") private WebElement continueButton;
	@FindBy(xpath = "//div[@class='error text-center']") public WebElement wrongpinerror;
	@FindBy(xpath = "//span[@class='su-message']") public WebElement invalidpinerror;
	// Constructor used to initialize data members
	public KitePinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	//methods used to give definitions to 
	public void Enterpin(String pin)
	{
		PIN.sendKeys(pin);
	}
	public void ClickContinueButoon()
	{
		continueButton.click();
		Reporter.log("Test Case Passed for Pin page and Pin validated succesfully",true);
	}
	
	public String wrongpinerrormsg()
	 {
		String actualwrongpinerrormsg = wrongpinerror.getText();
		return actualwrongpinerrormsg;
	 }
	 
	 public String invalididpinerrormsg()
	 {
		 String actualinvalididpinerrormsg = invalidpinerror.getText();	
		 return actualinvalididpinerrormsg;
	 }

}
