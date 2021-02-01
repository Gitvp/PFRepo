package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LoginPage extends BasePage {
	
	
	/*
	 * @FindBy(id="lid") public WebElement EmailField;
	 * 
	 * @FindBy(id="pwd") public WebElement PasswordField;
	 * 
	 * @FindBy(id="signin_submit") public WebElement SignInButton;
	 */
	
	@FindBy(id="login_id")
	public WebElement EmailField;
	
	@FindBy(id="nextbtn")
	public WebElement NextButton;
	
	@FindBy(id="password")
	public WebElement PasswordField;
	
	@FindBy(id="nextbtn")
	public WebElement SignButton;
	
	//Any other WebElements on Login page
	
	//Constructor code
	public LoginPage(WebDriver driver,ExtentTest eTest) {
		
		this.driver = driver;
		this.eTest = eTest;
		
	}
	
	
	//Reusable methods of Login page
	
	public boolean doLogin() {
		
		EmailField.sendKeys(Constants.USERNAME);
		eTest.log(LogStatus.INFO,"User Name got entered in to Email Address filed of login page");
		NextButton.click();
		eTest.log(LogStatus.INFO,"User clicked on signid of login page");
		PasswordField.sendKeys(Constants.PASSWORD);
		eTest.log(LogStatus.INFO,"User password got entered in to Email Address filed of login page");
		HomePage homePage = new HomePage(driver, eTest);
		PageFactory.initElements(driver, homePage);
		
		boolean loginStatus = homePage.verifyDisplayOfHomePage();
		
		return loginStatus;
		
	}
	
	//Any other reusable methods
	
	
	

}
