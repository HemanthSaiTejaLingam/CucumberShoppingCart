package stepdef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dtdemostepdef {
	WebDriver driver;
	@Given("User is on register page")
	public void user_is_on_register_page() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
	    	}

	@When("User enter following details")
	public void user_enter_following_details(io.cucumber.datatable.DataTable t1) {
		List<List<String>> rows = t1.asLists();
		String Gender = rows.get(1).get(1);
		String fname = rows.get(2).get(1);
		String lname = rows.get(3).get(1);
		String email = rows.get(4).get(1);
		String pwd = rows.get(5).get(1);
		String cnfpwd = rows.get(6).get(1);
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys(fname);
		driver.findElement(By.id("LastName")).sendKeys(lname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(cnfpwd);


	    	}

	@Then("User click on register")
	public void user_click_on_register() {
		driver.findElement(By.id("register-button")).click();
	    	}

	@Then("User register successfully")
	public void user_register_successfully() {
		System.out.println("User registered successfully");
	    	}

	
}
