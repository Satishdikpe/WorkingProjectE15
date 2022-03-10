package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialMediaPage {
WebDriver driver;
private static final Logger logger = LogManager.getLogger(SocialMediaPage.class);
private By TwitterAC = By.xpath("//li[@class='twitter']//a[@target='_blank']");
private By ActualAcHAndle = By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/span");
private By ActualAccountName = By.xpath("//span/span/span[text()='Selenium Framework']");
public SocialMediaPage(WebDriver driver){
	this.driver = driver;
}
public void Clicking_On_Twitter() {
	driver.findElement(TwitterAC).click();
}
public String AcHandle() {
	return driver.findElement(ActualAcHAndle).getText();
}
public String AcName() {
	return driver.findElement(ActualAccountName).getText();
}
}
