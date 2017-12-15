package finalAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC1_bookFlight {
	
	WebDriver driver;
	
	public TC1_bookFlight(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='passFirst0']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='passLast0']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='creditnumber']")
	WebElement credit;
	
	@FindBy(xpath="//input[@name='buyFlights']")
	WebElement purchase;
	
	
	public void bookFlight(String fname, String lname, String cnum) throws InterruptedException
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		credit.sendKeys(cnum);
		Thread.sleep(4000);
		purchase.click();
		Thread.sleep(4000);
	}
	

}
