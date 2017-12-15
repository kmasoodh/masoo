package finalAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC1_selectFlight {

	WebDriver driver;

	public TC1_selectFlight(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Blue Skies Airlines$361$271$7:10']")
	WebElement departFlight;
	
	@FindBy(xpath = "//input[@value='Unified Airlines$633$303$18:44']")
	WebElement returnFlight;
	
	@FindBy(xpath = "//input[@name='reserveFlights']")
	WebElement flightCont;
	
	public void selectFlight() throws InterruptedException
	{
		departFlight.click();
		returnFlight.click();
		Thread.sleep(3000);
		flightCont.click();
		}
	
}
