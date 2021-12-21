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

public class ZerodhakiteAppTest extends base.Baseclass
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
		login.EnterUserId(utilityclass.getdatafromproperty("UID"));
		login.EnterPassword(utilityclass.getdatafromproperty("PWD"));
		login.ClickLoginbutton();
//		Thread.sleep(1000);
		pin.Enterpin(utilityclass.getdatafromproperty("PIN"));
		pin.ClickContinueButoon();
//		Thread.sleep(1000);
	}
	
  @Test
  public void UserIDValid() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  int TCID=13;
//		Thread.sleep(1000);
		String ActualUserID = home.useridvalidation();
		String ExpectedUserID = utilityclass.getdatafromproperty("UID");
		Reporter.log("Validating UserID", true);
//		Thread.sleep(2000);
		Assert.assertEquals(ActualUserID, ExpectedUserID,"User ID not matching TC is Failed");
		Reporter.log("User ID Matching, TC "+TCID+" is passed",true);
		Reporter.log("Taking screenshot", true);
		
//		Thread.sleep(1000);
		utilityclass.screenshot(driver, TCID);	  	  
  }  
    
  @AfterMethod
  public void logout() throws InterruptedException
  {
//	  Thread.sleep(2000);
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
