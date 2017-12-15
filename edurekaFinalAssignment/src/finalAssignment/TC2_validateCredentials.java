package finalAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

@Listeners(Listener.class)
public class TC2_validateCredentials {
	WebDriver driver;
    public TC2_validateCredentials() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MASOODH\\SeleniumTraining\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
				PageFactory.initElements(driver, this);
		}
	@Test
	public void validateCredntials() throws InterruptedException {
		TC1_mercuryLogin loginPage = new TC1_mercuryLogin(driver);
		loginPage.login("Seletrain", "Sele@123");
	}

	

	@AfterTest
	public void close() {
		driver.quit();
	}

	@AfterSuite
	public void tearDown() {
		sendPDFReportByMail("M1034410@mindtree.com", "Jan@2018", "kmasoodh@gmail.com",
				"Flight Ticket Booking Confirmation", "");
	}

	private static void sendPDFReportByMail(String from, String pass, String to, String subject, String body) {
		Properties mail = System.getProperties();
		String host = "smtp-mail.outlook.com";
		mail.put("mail.smtp.starttls.enable", "true");
		mail.put("mail.smtp.host", host);
		mail.put("mail.smtp.user", from);
		mail.put("mail.smtp.password", pass);
		mail.put("mail.smtp.body", body);
		mail.put("mail.smtp.port", "587");
		mail.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(mail);
		MimeMessage message = new MimeMessage(session);

		try {

			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject(subject);
			message.setText(body);

			BodyPart objMessageBodyPart = new MimeBodyPart();

			objMessageBodyPart.setText("Please download your ticket from the attachements. Thank you!");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(objMessageBodyPart);

			objMessageBodyPart = new MimeBodyPart();

			String filename = System.getProperty("user.dir") + "\\Mercury Tours Ticket Booking.pdf";

			DataSource source = new FileDataSource(filename);

			objMessageBodyPart.setDataHandler(new DataHandler(source));

			objMessageBodyPart.setFileName(filename);

			multipart.addBodyPart(objMessageBodyPart);

			message.setContent(multipart);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
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

	

}



