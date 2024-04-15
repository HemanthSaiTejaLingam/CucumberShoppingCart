package stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstepdef {
	WebDriver driver;
	@Given("joe is on loginpage")
	public void joe_is_on_loginpage() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
		
	    	}

	@When("joe enters credentials")
	public void joe_enters_credentials() {
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("QEtester1");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pass@1234$$"); 
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    	}

	@Then("Demowebshop homepage display")
	public void demowebshop_homepage_display() {
		System.out.println("Title is-->"+driver.getTitle());
	    	}

}
