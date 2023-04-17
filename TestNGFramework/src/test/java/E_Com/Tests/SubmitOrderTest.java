package E_Com.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import E_Com.TestComponents.BaseTest;
import E_Com.TestComponents.Retry;
import E_com.Pom.CartPage;
import E_com.Pom.CheckOutPage;
import E_com.Pom.ConfirmationPage;
import E_com.Pom.LandingPage;
import E_com.Pom.OrdersPage;
import E_com.Pom.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
	String productName = "ZARA COAT 3";
	String countryName = "india";
	
	@Test(dataProvider="getData", groups={"purchase"},retryAnalyzer = Retry.class)
	public void submitOrder(String email,String password,String productName) throws IOException{
		ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCare(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean result = cartPage.verifyProductDisplayInCart(productName);
		Assert.assertTrue(result);
		CheckOutPage checkOutPage = cartPage.goToCehckOutPage();
		checkOutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = {"submitOrder","submitOrderNew","submitOrderWithJsonData"})
	public void orderHistoryTest() {
		//to verify product is displayed in orders
		ProductCatalogue productCatalogue = landingPage.loginApplication("testautomation@yahoo.com", "Test@123");
		OrdersPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"testautomation@yahoo.com","Test@123","ZARA COAT 3"},
			{"testautomation1@yahoo.com","Test@123","ADIDAS ORIGINAL"}};
	}
	@DataProvider
	public Object[][] getDataNewMethod() {
		HashMap<String,String> map = new HashMap();
		map.put("email", "testautomation@yahoo.com");
		map.put("password","Test@123");
		map.put("product", "ZARA COAT 3");
		HashMap<String,String> map1 = new HashMap();
		map1.put("email", "testautomation1@yahoo.com");
		map1.put("password","Test@123");
		map1.put("product", "ADIDAS ORIGINAL");
		return new Object[][] {{map},{map1}};
	}
	@Test(dataProvider="getDataNewMethod", groups={"purchaseNew"},retryAnalyzer = Retry.class)
	public void submitOrderNew(HashMap<String,String> input) throws IOException{
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCare(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean result = cartPage.verifyProductDisplayInCart(input.get("product"));
		Assert.assertTrue(result);
		CheckOutPage checkOutPage = cartPage.goToCehckOutPage();
		checkOutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@DataProvider
	public Object[][] getJsonData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") +"//src//test//java//E_Com//TestData//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	@Test(dataProvider="getJsonData", groups={"purchaseFromJsonData"},retryAnalyzer = Retry.class)
	public void submitOrderWithJsonData(HashMap<String,String> input) throws IOException{
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCare(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean result = cartPage.verifyProductDisplayInCart(input.get("product"));
		Assert.assertTrue(result);
		CheckOutPage checkOutPage = cartPage.goToCehckOutPage();
		checkOutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	
	
	
	
	
	
	
	
	

}
