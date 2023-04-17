package E_com.Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E_com.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver; // this driver has no life. to give life this driver create the constructor and 
	//call the driver from where it initialize 
	//(create the object of this class in that class and pass driver as an argument.)
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Pagefactory design pattern for storing the locators.

	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement ele;
	
	By ElementToAppear = By.cssSelector(".mb-3"); // for waiting to load the products.
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(ElementToAppear);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
	}
	public void addProductToCare(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(ele);
	}

	
	
	
	
	
	
	
	
	
	
	
	
}




