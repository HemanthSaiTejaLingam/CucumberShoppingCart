package cucumber;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ExpressionsStepDefinition {
	WebDriver driver;
	@Given("joe login to TestMeApp with {string} and {string}")
	public void joe_login_to_test_me_app_with_and(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
	    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
	    
	    driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
	    
	}

	@When("Joe search for {string} in the search box")
	public void joe_search_for_in_the_search_box(String item) {
		driver.findElement(By.id("myInput")).sendKeys(item);
		driver.findElement(By.cssSelector("input[type='submit'][name='val']")).click();
		String s1=driver.findElement(By.xpath("/html/body/section/div/div/div[2]")).getText();
		System.out.println(s1);
		if(s1.equals("Sorry no products available in this category. Please try some other")) {
			System.out.println("No product is available");
		}
		else {
		Boolean b= s1.contains(item);
		Assert.assertTrue(b);
		}
	}

	@Then("TestMeApp display all the products matching with the keyword")
	public void test_me_app_display_all_the_products_matching_with_the_keyword() {
	    driver.quit();
	}
}
