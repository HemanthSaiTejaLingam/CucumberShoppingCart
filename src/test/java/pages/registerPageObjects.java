package pages;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registerPageObjects {
	private WebDriver driver;
	@FindBy(how=How.ID,using="userName")
	private WebElement uname;
	@FindBy(how=How.ID,using="firstName")
	private WebElement fname;
	@FindBy(how=How.ID,using="lastName")
	private WebElement lname;
	@FindBy(how=How.ID,using="password")
	private WebElement pass;
	@FindBy(how=How.ID,using="pass_confirmation")
	private WebElement cpass;
	@FindBy(how=How.CSS,using="input[type='radio'][value='Female']")
	private WebElement female;
	@FindBy(how=How.CSS,using="input[type='radio'][value='Male']")
	private WebElement male;
	@FindBy(how=How.ID,using="emailAddress")
	private WebElement mail;
	@FindBy(how=How.ID,using="mobileNumber")
	private WebElement mobile;
	@FindBy(how=How.XPATH,using="//*[@id=\'dob\']")
	private WebElement dob;
	@FindBy(how=How.ID,using="address")
	private WebElement address;
	@FindBy(how=How.ID,using="securityQuestion")
	private WebElement ques;
	@FindBy(how=How.ID,using="answer")
	private WebElement ans;
	@FindBy(how=How.CSS,using="input[type='submit']")
	private WebElement register;
	@FindBy(how=How.XPATH,using="//*[@id=\'errormsg\'][4]")
	private WebElement res;
	
	public registerPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register(io.cucumber.datatable.DataTable dataTable){
		Map <String,String> rows = dataTable.asMap(String.class,String.class);
		uname.sendKeys(rows.get("uname"));
		fname.sendKeys(rows.get("fname"));
		lname.sendKeys(rows.get("lname"));
		pass.sendKeys(rows.get("pass"));
		cpass.sendKeys(rows.get("cpass"));
		if(rows.get("gender").equals("Female")) {
			female.click();
		}
		else {
			male.click();
		}
		
		mail.sendKeys(rows.get("mail"));
		mobile.sendKeys(rows.get("mobile"));
		dob.sendKeys(rows.get("dob"));
		address.sendKeys(rows.get("address"));
		Select s1=new Select(ques);
		s1.selectByVisibleText(rows.get("ques"));
		ans.sendKeys(rows.get("answer"));
		register.click();
	}
	public void check() {
		Assert.assertEquals(res.getText(),"User Registered Succesfully!!! Please login");
		driver.quit();
	}
}
