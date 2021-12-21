package testNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.KiteHomePage;
import pom.KiteLoginPage;
import pom.KitePinPage;
import utility.utilityclass;

public class UserIdErrrorMsgVal extends base.Baseclass 
{
	pom.KiteLoginPage login;
	pom.KitePinPage pin;
	pom.KiteHomePage home;	
	utility.utilityclass excel;
	
	@BeforeClass
	public void intitbrowser() throws EncryptedDocumentException, IOException
	{
		launchBrowser();
		login = new KiteLoginPage(driver);
		pin = new KitePinPage(driver);
		home = new KiteHomePage(driver);
		
	}
	
	@BeforeMethod
	public void logging_into_app() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.EnterUserId(utilityclass.userdataexcel(5, 0));
		login.EnterPassword(utilityclass.userdataexcel(5, 1));
		login.ClickLoginbutton();
		Thread.sleep(1000);
//		pin.Enterpin(utilityclass.userdataexcel(1, 2));
//		pin.ClickContinueButoon();
//		Thread.sleep(1000);
	}
	@Test
	  public void UserIDerrormsgValid() throws EncryptedDocumentException, IOException, InterruptedException 
	  {
		  int TCID=11;
			Thread.sleep(1000);
			String ActualUserIDerrormsg = login.iderrormsg();
			String ExpectedUserIDerrormsg = utilityclass.userdataexcel(1,3);
			Reporter.log("Validating UserIDerrror msg", true);
			Thread.sleep(2000);
			Assert.assertEquals(ActualUserIDerrormsg, ExpectedUserIDerrormsg,"User ID errror msg not matching TC is Failed");
			Reporter.log("User ID error msg Matching, TC "+TCID+" is passed",true);
			Reporter.log("Taking screenshot", true);
			Thread.sleep(1000);
			utilityclass.screenshot(driver, TCID);	  
		  
	  }
	
	  
	  @AfterMethod(enabled= false)
	  public void logout() throws InterruptedException
	  {
		  Thread.sleep(2000);
		  Reporter.log("Logging out from kite app", true);
		  home.logoutApp();
	  }
	  
	  @AfterClass
	  public void closebrowser()
	  {
		  Reporter.log("closing Browser", true);
		  driver.close();
	  }
}
