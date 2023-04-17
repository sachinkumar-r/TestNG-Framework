package E_Com.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import E_com.Pom.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//E_com//Resources//GlobalData.properties");
		prop.load(file);
		String browserName= System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		if(browserName.contains("headless")) {
			option.addArguments("headless");
		}
		driver = new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1440,900)); //full screen mode.
	}
		else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
		
	}
	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException{
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath));
		
		// string to hashmap using jackson databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
		@BeforeMethod(alwaysRun = true)
		public LandingPage launchApplication() throws IOException {
			driver = initializeDriver();
			landingPage = new LandingPage(driver);
			landingPage.goTo();
			return landingPage;
		
		}
		@AfterMethod(alwaysRun = true)
		public void tearDown() {
			driver.close();
		}
		
		public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png";
		}
		
			
		
	}