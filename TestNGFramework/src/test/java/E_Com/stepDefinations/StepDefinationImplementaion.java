package E_Com.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import E_Com.TestComponents.BaseTest;
import E_com.Pom.CartPage;
import E_com.Pom.CheckOutPage;
import E_com.Pom.ConfirmationPage;
import E_com.Pom.LandingPage;
import E_com.Pom.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImplementaion extends BaseTest{

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page.")
	public void I_landed_on_Ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String userName, String password) {
		productCatalogue = landingPage.loginApplication(userName, password);
	}
	@When("^I add (.+) to the cart.$")
	public void I_add_product_to_the_cart(String productName) {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCare(productName);
	}
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean result = cartPage.verifyProductDisplayInCart(productName);
		Assert.assertTrue(result);
		CheckOutPage checkOutPage = cartPage.goToCehckOutPage();
		checkOutPage.selectCountry("india");
		confirmationPage = checkOutPage.submitOrder();
	}
	@Then("{string} message is displayed on confirmation page.")
	public void message_is_displayed_on_confirmation_page(String string) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));	
	}
}
