import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxes {
	/*
	 * Navigate to Below URL: https://rahulshettyacademy.com/AutomationPractice/
	 * 
	 * 1.Check the first Checkbox and verify if it is successfully checked and
	 * Uncheck it again to verify if it is successfully Unchecked. 2.How to get the
	 * Count of number of check boxes present in the page
	 */
	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// 1.
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected()); // true
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected()); // false
		// 2.
		System.out.println(driver.findElements(By.cssSelector("input[name*='checkBoxOption']")).size()); // 3

	}
}
