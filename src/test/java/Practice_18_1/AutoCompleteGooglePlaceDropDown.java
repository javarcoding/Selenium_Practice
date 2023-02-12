package Practice_18_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteGooglePlaceDropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users/adsul/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.twoplugs.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()=\"Live Posting\"]")).click();
		
		WebElement searchbox=driver.findElement(By.id("autocomplete"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Toronto");
		
		String text;
		do {
			searchbox.sendKeys(Keys.ARROW_DOWN);
			text=searchbox.getAttribute("value");
			if (text.equals("Toronto, OH, USA")) {
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
			
		} while (!text.isEmpty());
		
		
	}
}
