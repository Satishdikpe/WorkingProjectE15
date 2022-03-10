package Pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageFactory {
	static WebDriver driver=null ;
private static final Logger logger = LogManager.getLogger(PageFactory.class);

public WebDriver Invoking_Browser(String browser) {
	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		logger.info("Crome Browser Invoked");
	}else if(browser.equalsIgnoreCase("Firefox")) {
		driver = new FirefoxDriver();
		logger.info("Firebox bowser Inoked");
	}else {
		System.out.println("Wrong browser entered");
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	return driver;
}

public void switchingTab() {
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> itr=handles.iterator();
	String Parent_Window_ID = itr.next();
	String Child_Window_ID = itr.next();
	driver.switchTo().window(Child_Window_ID);
}
public void switchingTabToOriginal() {
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> itr=handles.iterator();
	String Parent_Window_ID = itr.next();
	
	driver.switchTo().window(Parent_Window_ID);
}

}
