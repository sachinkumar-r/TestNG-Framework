package E_Com.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import E_Com.TestComponents.BaseTest;
import E_Com.TestComponents.Retry;
import E_com.Pom.CartPage;
import E_com.Pom.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException {
		landingPage.loginApplication("testautomation@yahoo.com", "Test123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
	public void productErrorValidation() {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("testautomation@yahoo.com", "Test@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCare(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean result = cartPage.verifyProductDisplayInCart("ZARA COAT 33");
		Assert.assertFalse(result);
	}
}
