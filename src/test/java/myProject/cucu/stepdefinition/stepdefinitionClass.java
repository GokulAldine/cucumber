package myProject.cucu.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefinitionClass extends hooks {
	static WebDriver web;
	static ChromeOptions options;

	@Given("launch the MakeMyTrip web page")
	public void launch_the_MakeMyTrip_web_page() throws IOException {
		WebDriverManager.chromedriver().setup();
//	    ChromeOptions options = new ChromeOptions();
//	    options.addArguments("start-maximized");
//	    options.addArguments("--headless");
//	    options.addArguments("--incognito");
//	    options.addArguments("diable-popup");
//	    options.addArguments("--version"); 
//	    
	/*	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME,"ChromeDriver");
		capabilities.setCapability("ChromeDriver.IS_CHROMIUM_BROWSER", true);*/
		
		
		
		
		web = new ChromeDriver();
		//File f = new File("src\\test\\resources\\PropertyFile\\credential.property");
		//FileInputStream fi = new FileInputStream(f);
	//	Properties p = new Properties();
		//p.load(fi);
		//String property = p.getProperty("URL");
	    web.get("https://www.makemytrip.com/");
	   web.manage().window().maximize();
	   
	}
	
	@And("user selecting the city destination")
	public void user_selecting_the_city_destination() throws AWTException, Throwable {		
	  WebElement fromCity = web.findElement(By.xpath("//input[@data-cy='fromCity']"));
	  fromCity.sendKeys("Chennai",Keys.ENTER);
	  String text = fromCity.getText();
	  System.out.println(text);
	  Thread.sleep(3000);	 
	  Robot r = new Robot();
	   r.keyPress(KeyEvent.VK_DOWN);
	   r.keyRelease(KeyEvent.VK_DOWN);
	   r.keyPress(KeyEvent.VK_ENTER);
	   WebElement toCity = web.findElement(By.xpath("//input[@data-cy='toCity']"));
	   toCity.sendKeys("Goa",Keys.ENTER);
	   String text1 = fromCity.getText();
		  System.out.println(text1);
		  Thread.sleep(3000);
		  r.keyPress(KeyEvent.VK_DOWN);
		   r.keyRelease(KeyEvent.VK_DOWN);
		   r.keyPress(KeyEvent.VK_ENTER);
		   }

	@And("user selecting the month and date")
	public void user_selecting_the_month_and_date() {
	web.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS)	;
	  WebElement clicking = web.findElement(By.xpath("(//p[text()='₹ 2,849'])[4]"));
	  clicking.click();
	  web.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  web.findElement(By.xpath("//a[text()='Search']")).click();
	  WebElement scrollDown = web.findElement(By.xpath("//p[text()='Arrival at Goa - Dabolim Airport']"));
	  JavascriptExecutor js = (JavascriptExecutor) web;
	  js.executeScript("arguments[0].scrollIntoView(true)",scrollDown);
	  
	  WebElement box = web.findElement(By.xpath("(//input[@id='listingFilterCheckbox'])[9]"));
	  	  Actions ac = new Actions(web);
	  	 web.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	  ac.moveToElement(box).click().build().perform();	  	 
	       }

	@Then("user exit")
	public void user_exit() throws InterruptedException {
    web.navigate().back();
    Thread.sleep(5000);
    web.quit();
	}

	
	
	
}
