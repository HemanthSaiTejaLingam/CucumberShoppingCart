package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {
	WebDriver driver;
	@Given("Joe is on log in page of TestMe App")
	public void joe_is_on_log_in_page_of_test_me_app() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
	}

	@When("Joe enter his credentials")
	public void joe_enter_his_credentials() {
		driver.findElement(By.id("userName")).sendKeys("Naruto34");
		driver.findElement(By.id("password")).sendKeys("Pass1234");
	}
	
	@When("clicks on login")
	public void clicks_on_login() {
		driver.findElement(By.name("Login")).click();
	}
	

	@Then("Joe logins Successfully to the TestMe App")
	public void joe_logins_successfully_to_the_test_me_app() {
	    Assert.assertEquals("Home",driver.getTitle());
	    driver.close();
	}

}
