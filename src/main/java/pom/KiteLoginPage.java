package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage
{
	//Data members/variables/Elements declaration using @FindBy method
		@FindBy(id="userid") private WebElement UserId;
		@FindBy(id="password") private WebElement Password;
		@FindBy(xpath = "//button[@class='button-orange wide']") private WebElement LoginButton;
		@FindBy(xpath="(//span[@class='su-message'])[1]") public WebElement useriderror;
		@FindBy(xpath="(//span[@class='su-message'])[2]") public WebElement pinerror;
		@FindBy(xpath="//p[@class='error text-center']") public WebElement invalid_id_pwd;
		// Constructor used to initialize data members
				

		public KiteLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);	
		}


		//methods used to give definitions to 
		public void EnterUserId(String ID)
		{
			UserId.sendKeys(ID);
		}
		 public void EnterPassword(String Pass)
		 {
			 Password.sendKeys(Pass);
		 }
		 public void ClickLoginbutton()
		 {
			 LoginButton.click();
			
		 }
		 
		 public String iderrormsg()
		 {
			String actualiderrodmsg = useriderror.getText();	
			return actualiderrodmsg;
		 }

		 public String pinerrormsg()
		 {
			 String actualpinerrodmsg = pinerror.getText();	
			 return actualpinerrodmsg;
		 }
		 
		 public String invalididpwderrormsg()
		 {
			 String invalididpwderrormsg = invalid_id_pwd.getText();	
			 return invalididpwderrormsg;
		 }
}
