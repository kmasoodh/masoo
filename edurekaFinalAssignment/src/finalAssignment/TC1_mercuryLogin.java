package finalAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC1_mercuryLogin {
	
	 WebDriver driver;
		
		/*public TC1_mercuryLogin(WebDriver ldriver)
		{
			this.driver=ldriver;	
		}*/
		 
		 public TC1_mercuryLogin(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
		 }
		
		@FindBy(name="userName")
		WebElement uname;
		
		@FindBy(name="password")
		WebElement pword;
		
		@FindBy(name="login")
		@CacheLookup
		WebElement login;
		
		public  void login(String id, String pass) throws InterruptedException
		{		
			
			uname.sendKeys(id);
			pword.sendKeys(pass);
			Thread.sleep(3000);
			login.click();
		}
		String Login ="Login Sucessfull";
}

