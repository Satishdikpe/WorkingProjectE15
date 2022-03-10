package Stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Pages.PageFactory;
import Pages.ProductPage;
import Pages.SocialMediaPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.UtilitiesAct;

public class StepDef {
	WebDriver driver;
	String URLWeb = "http://automationpractice.com";
	PageFactory pagefactory;
	LoginPage loginpage;
	ProductPage propage;
	SocialMediaPage somePage;
	private static final Logger logger = LogManager.getLogger(StepDef.class);
	
	@Before
	public void Setup() {
		pagefactory = new PageFactory();
		driver = pagefactory.Invoking_Browser("chrome");
		loginpage = new LoginPage(driver);
		propage = new ProductPage(driver);
		somePage = new SocialMediaPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Use invoking to browser ");
		}
	@After(order=0)
	public void tearup() {
		driver.quit();
		logger.info("browser quited ");
	}
	@After(order= 1)
	public void scrennshot(Scenario scn) {
		TakesScreenshot screenshottaken = (TakesScreenshot)driver;
		byte[] shots = screenshottaken.getScreenshotAs(OutputType.BYTES);
		scn.attach(shots, "image/png", scn.getName());
	}
	
	
	@Given("User Navigated to URL")
	public void user_navigated_to_url() {
		loginpage.NaigatedToHomePage(URLWeb);
	}

	@When("launching http:\\/\\/automationpractice.com")
	public void launching_http_automationpractice_com() {
	   loginpage.Current_URL();
	}

	@Then("Validate its  redirected to {string}")
	public void validate_its_redirected_to(String ExpectedURL) {
	  String ActualURL = loginpage.Current_URL();
	  Assert.assertEquals(ExpectedURL, ActualURL);
	  logger.info("Expected "+ExpectedURL+" and actual "+ActualURL+" matched ");
	
	}

	@When("The application logo is displayed")
	public void the_application_logo_is_displayed() {
	    loginpage.LogoValidation();
	}

	@Then("The application logo width is {int} & height is {int}")
	public void the_application_logo_width_is_height_is(Integer Expected_Width, Integer Expected_Height) {
	  if(Expected_Width == loginpage.Logowidth() && Expected_Height == loginpage.LogoHeight()) {
		  Assert.assertTrue(true);
		  logger.info("Logo size Matched "+Expected_Width+Expected_Height);
	  } else {
		  Assert.fail("Logo Size is not matched");
		  logger.info("LogoSize is not matched");
	  }
	}

	@When("Validate main product categories count should be {int}")
	public void validate_main_product_categories_count_should_be(Integer Expected_count) {
	    
	   Assert.assertEquals(Expected_count, loginpage.Product_Cat());
	}


@Then("{string} the displayed three categories is as shown below")
public void the_displayed_three_categories_is_as_shown_below(String ProductName) {
   loginpage.ProductName(ProductName);
}


	@When("Validate while entering the text {string} in search box")
	public void validate_while_entering_the_text_in_search_box(String Expected) {
	   propage.Product_text_box(Expected);
	}

	@Then("The search result contains {string} as text")
	public void the_search_result_contains_as_text(String product) {
	    propage.Product_drop_Down(product);
	}

	@When("user clicks on the twitter link form footer section form landing page of the application")
	public void user_clicks_on_the_twitter_link_form_footer_section_form_landing_page_of_the_application() {
	  somePage.Clicking_On_Twitter();
	  pagefactory.switchingTab();
	  logger.info("user clicked on twitterlink and opened new window "+driver.getTitle());
	}

	@Then("Validate the url opened on a new tab contains {string}")
	public void validate_the_url_opened_on_a_new_tab_contains(String Expected) {
	  String ActualTitle = somePage.AcHandle();
	  if(ActualTitle.contains(Expected)) {
	  logger.info("Actaul and Expected title matched : -"+ActualTitle);
	  }else {
		  Assert.fail("Actual"+ActualTitle+"is not matched with Expected"+Expected);
	  }
	  }

	@Then("the twiiter accont name is {string}")
	public void the_twiiter_accont_name_is(String Expected) {
	   String Actual = somePage.AcName();
	Assert.assertEquals(Expected, Actual);
	logger.info("Expected and Actual Account Name Is Matched "+Actual);
	}


}
