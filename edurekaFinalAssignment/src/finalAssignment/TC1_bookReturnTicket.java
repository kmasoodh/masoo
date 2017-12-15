package finalAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class TC1_bookReturnTicket {
	
	WebDriver driver;
	public TC1_bookReturnTicket() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MASOODH\\SeleniumTraining\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
				PageFactory.initElements(driver, this);
		}

	@Test
	public void bookTicket() throws InterruptedException {
		driver.manage().window().maximize();
		
		TC1_mercuryLogin loginPage = new TC1_mercuryLogin(driver);
		loginPage.login("Seletrain", "Sele@123");
		
		TC1_mercuryFlightFinder flightFind = new TC1_mercuryFlightFinder(driver);
		flightFind.findFlight();
		
		TC1_selectFlight selFlight = new TC1_selectFlight(driver);
		selFlight.selectFlight();
		
		TC1_bookFlight bkFlight = new TC1_bookFlight(driver);
		bkFlight.bookFlight("Mohamed", "Masoodh", "411156879639321");
	}

	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	@BeforeMethod
	 
	public void beforeMethod() {

		System.out.println("Method Execution started");

	}

	@AfterMethod

	public void afterMethod() {

		System.out.println("Method execution completed");

	}

	@BeforeClass

	public void beforeClass() {

		System.out.println("Class Execution Started");

	}

	@AfterClass

	public void afterClass() {

		System.out.println("Class execution completed");

	}

	@BeforeTest

	public void beforeTest() {

		System.out.println("Test Started");

	}

	@BeforeSuite

	public void beforeSuite() {

		System.out.println("Test Suite started");

	}

	@AfterSuite

	public void afterSuite() {

		System.out.println("Test Suite completed");

	}

}


