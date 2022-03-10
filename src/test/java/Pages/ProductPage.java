package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.UtilitiesAct;



public class ProductPage {
WebDriver driver;
private By dropSearchBox = By.xpath("//div//li[@class='ac_even ac_over']");
private By SearchTextBox = By.xpath("//input[@id='search_query_top']");
private static final Logger logger = LogManager.getLogger(ProductPage.class);

public ProductPage(WebDriver driver) {
	this.driver = driver;
}
public void Product_text_box(String product) {
	driver.findElement(SearchTextBox).sendKeys(product);
	
}
public String Product_drop_Down(String product) {

//	Actions act = new Actions(driver);
//	act.moveToElement(driver.findElement(SearchTextBox)).moveToElement(driver.findElement(dropSearchBox)).build().perform();
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.presenceOfElementLocated(dropSearchBox));
	return driver.findElement(dropSearchBox).getText();
	
}

}
