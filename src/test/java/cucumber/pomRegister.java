package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.registerPageObjects;

public class pomRegister {
	private WebDriver driver;
	private registerPageObjects registerPOM;
	@Given("The user opens the registration page")
	public void the_user_opens_the_registration_page() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/RegisterUser.htm");
	  
	    registerPOM=new registerPageObjects(driver);
	}

	@When("The user enters necessary details and registers")
	public void the_user_enters_necessary_details_and_registers(io.cucumber.datatable.DataTable dataTable) {
	    registerPOM.register(dataTable);
	}
	
	@Then("user must successfully register")
	public void user_must_successfully_register() {
		registerPOM.check();
	}
}
