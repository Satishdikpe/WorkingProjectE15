package Pages;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
private WebDriver driver;
private By LogoImage = By.xpath("//img[@class='logo img-responsive']");
private By Product_Category = By.xpath("//*[@id=\"block_top_menu\"]/ul/li");
private static final Logger logger = LogManager.getLogger(LoginPage.class);
public LoginPage(WebDriver driver) {
	this.driver = driver;
}

public void NaigatedToHomePage(String URL) {
	driver.get(URL);
	logger.info("browser opened WebPage "+URL);
}
public String Current_URL() {
	String actualURL = driver.getCurrentUrl();
	logger.info("Current URL "+driver.getCurrentUrl());
	return actualURL;
}
public void LogoValidation() {
	if (driver.findElement(LogoImage).isDisplayed()) {
	Assert.assertTrue(true);
	logger.info("Logo is displayed on the page");
	}else {
		Assert.fail("Logo is not displayed");
		logger.info("Logo is not  displayed on the page");
	}
}
public int Logowidth() {
	int width = driver.findElement(LogoImage).getSize().width;
	return width;
 }
public int LogoHeight() {
	int Height = driver.findElement(LogoImage).getSize().height;
	return Height;
}

public Integer Product_Cat() {
	Integer Actual_Count = driver.findElements(Product_Category).size();
	return Actual_Count;
}
public void ProductName(String Product) {
	 List<WebElement> list = driver.findElements(Product_Category);
	Iterator<WebElement> itr = list.iterator();
	while(itr.hasNext()) {
		if(Product.equals(itr.next().getText())) {
			Assert.assertTrue(true);
			logger.info("Product Category Matched with Expected ");
		}
	}
	}
}

