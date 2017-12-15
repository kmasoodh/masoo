package finalAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TC1_mercuryFlightFinder {

	WebDriver driver;

	public TC1_mercuryFlightFinder(WebDriver driver) {
		//this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='roundtrip']")
	WebElement oneway;
	
	@FindBy(xpath = "//select[@name='passCount']")
	WebElement passCount;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement fromPort;
	
	@FindBy(xpath = "//select[@name='fromMonth']")
	WebElement fromMonth;
	
	@FindBy(xpath = "//select[@name='fromDay']")
	WebElement fromDay;
	
	@FindBy(xpath = "//select[@name='toPort']")
	WebElement toPort;
	
	@FindBy(xpath = "//select[@name='toMonth']")
	WebElement toMonth;
	
	@FindBy(xpath = "//select[@name='toDay']")
	WebElement toDay;
	
	@FindBy(xpath = "//input[@value='First']")
	WebElement service;
	
	@FindBy(xpath = "//select[@name='airline']")
	WebElement airLine;
	
	@FindBy(xpath = "//input[@name='findFlights']")
	WebElement findCont;
	
	
	
	public void findFlight() throws InterruptedException
	{		
		//oneway.click();
		Select passcount = new Select(passCount);
		 passcount.selectByVisibleText("2");
		 
		 Select depart = new Select(fromPort);
		 depart.selectByVisibleText("New York");
		 
		 Select month = new Select(fromMonth);
		 month.selectByVisibleText("December");
		 
		 Select day = new Select(fromDay);
		 day.selectByVisibleText("24");
		 
		 Select arrive = new Select(toPort);
		 arrive.selectByVisibleText("Frankfurt");
		 
		 Select arrmonth = new Select(toMonth);
		 arrmonth.selectByVisibleText("December");
		 
		 Select arrday = new Select(toDay);
		 arrday.selectByVisibleText("30");
		 
		// WebElement service = new Select(service);
		 service.click();
		 
		 Select airline = new Select(airLine);
		 airline.selectByVisibleText("Blue Skies Airlines");
		 
		Thread.sleep(3000);
		
		findCont.click();
	}
	
}
