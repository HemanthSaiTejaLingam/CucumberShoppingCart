package cucumber;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registartionDataTable {
	WebDriver driver;
	@Given("The user is on Register page")
	public void the_user_is_on_register_page() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/RegisterUser.htm");
	}

	@When("The user enters the following details")
	public void the_user_enters_the_following_details(io.cucumber.datatable.DataTable dataTable) {
		Map <String,String> rows = dataTable.asMap(String.class,String.class);
		driver.findElement(By.id("userName")).sendKeys(rows.get("uname"));
		driver.findElement(By.id("firstName")).sendKeys(rows.get("fname"));
		driver.findElement(By.id("lastName")).sendKeys(rows.get("lname"));
		driver.findElement(By.id("password")).sendKeys(rows.get("pass"));
		driver.findElement(By.id("pass_confirmation")).sendKeys(rows.get("cpass"));
		if(rows.get("gender").equals("Female")) {
			driver.findElement(By.cssSelector("input[type='radio'][value='Female']")).click();
		}
		else {
			driver.findElement(By.cssSelector("input[type='radio'][value='Male']")).click();
		}
		
		driver.findElement(By.id("emailAddress")).sendKeys(rows.get("mail"));
		driver.findElement(By.id("mobileNumber")).sendKeys(rows.get("mobile"));
		driver.findElement(By.xpath("//*[@id=\'dob\']")).sendKeys(rows.get("dob"));
		driver.findElement(By.id("address")).sendKeys(rows.get("address"));
		Select s1=new Select(driver.findElement(By.id("securityQuestion")));
		s1.selectByVisibleText(rows.get("ques"));
		driver.findElement(By.id("answer")).sendKeys(rows.get("answer"));
		
	}

	@When("clicks on register button")
	public void clicks_on_register_button() {
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}

	@Then("the user must register successfully")
	public void the_user_must_register_successfully() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\'errormsg\'][4]")).getText(),
				"User Registered Succesfully!!! Please login");
		driver.quit();
	}


	@Given("the user is in home page of the TestMe App")
	public void the_user_is_in_home_page_of_the_test_me_app() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	}
	@When("user search for {string} in the search box")
	public void user_search_for_in_the_search_box(String item) {
		driver.findElement(By.id("myInput")).sendKeys(item);
		driver.findElement(By.cssSelector("input[type='submit'][name='val']")).click();
		String s1=driver.findElement(By.xpath("/html/body/section/div/div/div[2]")).getText();
		if(s1.equals("Sorry no products available in this category. Please try some other")) {
			System.out.println("No product is available");
		}
		else {
			Boolean b= s1.contains(item);
			Assert.assertTrue(b);
		}
	}
	@Then("TestMeApp display products matching with the keyword")
	public void test_me_app_display_products_matching_with_the_keyword() {
		driver.quit();
	}

}
