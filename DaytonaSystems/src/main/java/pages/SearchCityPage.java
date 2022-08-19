package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchCityPage {
	private static WebElement element = null;
	
	public static WebElement textbox_search(WebDriver driver)
	{
		element = driver.findElement(By.id("searchBox"));
		return element;
	}
	
	public static boolean verify_city(WebDriver driver,String city)
	{
		try
		{
			driver.findElement(By.xpath("//input[@id='"+city+"']"));
			return true;
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			return false;
		}
	}
	
	public static WebElement city_search(WebDriver driver,String city)
	{
		element = driver.findElement(By.xpath("//input[@id='"+city+"']"));
		return element;
	}
	
	public static WebElement temp_degree(WebDriver driver,String city)
	{
		element = driver.findElement(By.xpath("//div[@title='"+city+"']//div//span[@class='tempRedText']"));
		return element;
	}
	
	public static WebElement temp_fahrenheit(WebDriver driver,String city)
	{
		element = driver.findElement(By.xpath("//div[@title='"+city+"']//div//span[@class='tempWhiteText']"));
		return element;
	}
}
