package selenium;

import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchCityPage;


public class WeatherInIndianCity {
	WebDriver driver = null;
	
	//User enters the city name inorder to avoid hardcode 
	Scanner scan = new Scanner(System.in);
	static
	{
		System.out.println("Enter city name ");
	}
	String city = scan.next();
	public void CamelCase()
	{
		city = city.toLowerCase();
		city=city.substring(0, 1).toUpperCase()+city.substring(1);
	}
	
	
	boolean DataAvailable=true;
	
	@BeforeTest
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "E:/Selenium_ChromeDriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://social.ndtv.com/static/Weather/report/#pfrom=home-ndtv_topsubnavigation");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority=1)
	public void searchCity() {
		// Search the city name
		CamelCase();
		SearchCityPage.textbox_search(driver).clear();
		SearchCityPage.textbox_search(driver).sendKeys(city);
		
		if(SearchCityPage.verify_city(driver, city) == true)
		{
			
			System.out.println("City name "+city+" : found");
		}
		else
		{
			System.out.println("City name "+city+" : not found");
			DataAvailable = false;
		}
		
		
	}
	@Test(priority=2)
	public void temperature()
	{
		if(DataAvailable == false)
		{
			throw new SkipException("Couldnot fetch the Weather Condition of "+city);
		}
		else
		{
			//Print Temperation in Degrees and Fahrenheit
			String l= SearchCityPage.city_search(driver,city).getAttribute("checked");
			
			if(l==null)
			{
				SearchCityPage.city_search(driver,city).click();
			}
			
			
			String temp_deg = SearchCityPage.temp_degree(driver,city).getText();
			temp_deg=temp_deg.replaceAll("[^0-9.]", "");
			System.out.println("Temp in Degrees: "+temp_deg);
			String temp_fahr = SearchCityPage.temp_fahrenheit(driver,city).getText();
			temp_fahr=temp_fahr.replaceAll("[^0-9.]", "");
			System.out.println("Temp in Fahrenheit: "+temp_fahr);
		}
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

}
