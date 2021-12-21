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

public class WrongIdPassVal extends base.Baseclass
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
		login.EnterUserId(utilityclass.getdatafromproperty("UID1"));
		login.EnterPassword(utilityclass.getdatafromproperty("PIN1"));
		login.ClickLoginbutton();
//		Thread.sleep(1000);
//		pin.Enterpin(utilityclass.userdataexcel(1, 2));
//		pin.ClickContinueButoon();
//		Thread.sleep(1000);
	}
	@Test
	  public void invalidIDPasserrormsgValid() throws EncryptedDocumentException, IOException, InterruptedException 
	  {
		  int TCID=15;
//			Thread.sleep(1000);
			String Actualerrormsg = login.invalididpwderrormsg();
//			Thread.sleep(2000);
			String Expectederrormsg = utilityclass.getdatafromproperty("idpwderr");
			Reporter.log("Validating invalid ID pass error", true);
//			Thread.sleep(2000);
			Assert.assertEquals(Actualerrormsg, Expectederrormsg,"invalid Id Pass error msg not matching TC is Failed");
			Reporter.log("invalid ID Pass error msg Matching, TC "+TCID+" is passed",true);
			Reporter.log("Taking screenshot", true);
//			Thread.sleep(1000);
			utilityclass.screenshot(driver, TCID);	  
	  
	  }	
	  
	  @AfterMethod(enabled= false)
	  public void logout() throws InterruptedException
	  {
//		  Thread.sleep(2000);
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
