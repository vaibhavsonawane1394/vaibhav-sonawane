package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath = "//span[@class='user-id']") private WebElement userid;
	@FindBy(xpath = "//span[@class='icon icon-exit']") private WebElement logout;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String useridvalidation()
	{
		String actualinvalididpinerrormsg = userid.getText();
		return actualinvalididpinerrormsg;
	}
	
	public void logoutApp()	
	{
		userid.click();
		logout.click();
	}

}
