package Assignment;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpWindow {
	
	WebDriver d;
	String url="http://popuptest.com/goodpopups.html";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.get(url);
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}

	@Test
	public void test() {
		
		d.findElement(By.linkText("Good PopUp #2")).click();

		Set<String>windowHandle=d.getWindowHandles();						

		Iterator<String>s=windowHandle.iterator();								

		String parentWin=s.next();											
		String childWin=s.next();											

		d.switchTo().window(childWin);									

		System.out.println("Child Window Title : "+d.getTitle());
		d.close();														

		d.switchTo().window(parentWin);								
		System.out.println("Parent Window Title : "+d.getTitle());			
		
	}

}
