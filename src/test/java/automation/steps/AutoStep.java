package automation.steps;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import automation.page.AutoPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutoStep {
		WebDriver driver;
		AutoPage aPage;
	
	@Given("^user go the the automation homepage$")
	public void user_go_the_the_automation_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe"); 
		
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@When("^user click on the sign in button$")
	public void user_click_on_the_sign_in_button() throws Throwable {
	    aPage = new AutoPage(driver);
	    aPage.clickOnSigninButton();
	    
	}

	@When("^user enter valid email and password$")
	public void user_enter_valid_email_and_password() throws Throwable {
		aPage.enterValidEmailandPassword();
	}

	@When("^user click on sign in button$")
	public void user_click_on_sign_in_button() throws Throwable {
		aPage.clickOnSignIn();    
	    
	}

	@Then("^user navigate to the home page$")
	public void user_navigate_to_the_home_page() throws Throwable {
		aPage.navigateToHomePage();   
	    
	}

	@Then("^user verify the page title as \"([^\"]*)\"$")
	public void user_verify_the_page_title_as(String arg1) throws Throwable {
		String expected = "My account - My Store";
		String actual = driver.getTitle();
		Assert.assertTrue("Title does not match", actual.contains(expected));
	    
	}

	@Then("^user go to the upper left corner and select Dresses$")
	public void user_go_to_the_upper_left_corner_and_select_Dresses() throws Throwable {
	    aPage.goToUpperLeftSelectDresses();
	    
	}

	@Then("^user click on sort by highest order$")
	public void user_click_on_sort_by_highest_order() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1600)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> AllPrices = driver
				.findElements(By.xpath("//*[@class='product-desc']/following-sibling::div[1]"));
		ArrayList<String> NewList = new ArrayList<String>();
		for (int i = 0; i < AllPrices.size(); i++) {
			NewList.add(AllPrices.get(i).getText().toString());
		}
		Collections.sort(NewList, Collections.reverseOrder());
		System.out.println("List of prices in sorted order:" + NewList);
		String SecondPrice = NewList.get(1);
		System.out.println("Price of the Second Dress:" + SecondPrice);
	    
	}

	@Then("^user select the second highest item$")
	public void user_select_the_second_highest_item() throws Throwable {
	    aPage.SelectSecondHighest();
	    
	}

	@Then("^user click on add to cart button$")
	public void user_click_on_add_to_cart_button() throws Throwable {
	    aPage.addToCart();
	    
	}

	@Then("^user verify the total price and the shipping fee on checkout page$")
	public void user_verify_the_total_price_and_the_shipping_fee_on_checkout_page() throws Throwable {
	    aPage.verifyOnCheckout();
	    
	}

	@Then("^user sign out$")
	public void user_sign_out() throws Throwable {
		aPage.signOut();
	    
	}

	@Then("^user close the window$")
	public void user_close_the_window() throws Throwable {
		driver.close();
	    
	}
}
