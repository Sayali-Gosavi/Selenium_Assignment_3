package Assignment;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenClinic {
	
	WebDriver d;
	String url="http://openclinic.sourceforge.net/openclinic/home/index.php";

	@Before
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver.exe");
		d=new ChromeDriver();
		d.get(url);
		d.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}

	@Test
	public void test() throws InterruptedException {
		//Opening Medical Records in new tab
		String NewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		d.findElement(By.linkText("Medical Records")).sendKeys(NewTab);
		
		//switchint handle to next tab
		Set<String> WindowHandle = d.getWindowHandles();
		for(String Tab:WindowHandle) {
			d.switchTo().window(Tab);
		}
		
		//click on search patient link
		d.findElement(By.linkText("Search Patient")).click();
		
		//select value from dropdown
		WebElement Field = d.findElement(By.id("search_type"));
		Select field = new Select(Field);
		field.selectByVisibleText("First Name");
		
		//click on search patient button
		d.findElement(By.id("search_patient")).click();
		
		
		
	}

}
