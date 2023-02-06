package myProject.cucu.stepdefinition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks {
public static WebDriver web ;
	
	@Before
	public void beforeClass() {
		System.out.println("driver launched");
	
	
}
	@After
	public void afterClass() {
		System.out.println("driver closed");
		//web.quit();
		
	}
	
}