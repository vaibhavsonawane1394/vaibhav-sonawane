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

public class PinErrorVal extends base.Baseclass
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
//			Thread.sleep(1000);
			pin.Enterpin(utilityclass.getdatafromproperty("PIN1"));
			pin.ClickContinueButoon();
//			Thread.sleep(1000);
		}
		@Test
		  public void UserIDerrormsgValid() throws EncryptedDocumentException, IOException, InterruptedException 
		  {
			  int TCID=14;
//				Thread.sleep(1000);
				String Actualpinerrormsg = pin.wrongpinerrormsg();
				String Expectedpinerrormsg = utilityclass.getdatafromproperty("pinerror");
				Reporter.log("Validating pin error", true);
//				Thread.sleep(2000);
				Assert.assertEquals(Actualpinerrormsg, Expectedpinerrormsg,"pin error msg not matching TC is Failed");
				Reporter.log("Pin error msg Matching, TC "+TCID+" is passed",true);
				Reporter.log("Taking screenshot", true);
//				Thread.sleep(1000);
				utilityclass.screenshot(driver, TCID);	  
			  
		  }		
		  
		  @AfterMethod(enabled= false)
		  public void logout() throws InterruptedException
		  {
//			  Thread.sleep(2000);
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
