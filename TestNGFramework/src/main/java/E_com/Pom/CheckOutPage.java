package E_com.Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import E_com.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css = ".form-group button:nth-of-type(2)")
	WebElement selectCountry;
	
	By result = By.cssSelector(".form-group section");
	
	public void selectCountry(String countryName) {
		
		Actions act = new Actions(driver);
		act.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(result);
		selectCountry.click();
	}
	public ConfirmationPage submitOrder() {
		submit.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
		
		
	}

}
