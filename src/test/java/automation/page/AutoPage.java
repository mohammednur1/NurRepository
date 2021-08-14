package automation.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutoPage {
	
	public AutoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//*[@class='login']")
	private static WebElement signInBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	private static WebElement email;
	
	@FindBy(how = How.XPATH, using = "//*[@name='passwd']")
	private static WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id='SubmitLogin']")
	private static WebElement loginInBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@class='account']")
	private static WebElement nurMo;
	
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Dresses')])[5]")
	private static WebElement Dresses;
	
	@FindBy(how = How.XPATH, using = "(//*[@itemprop='name'])[4]")
	private static WebElement SecondItem;
	
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Add to cart')])[4]")
	private static WebElement AddToCart;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Proceed to checkout')]")
	private static WebElement checkOut;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Log me out']")
	private static WebElement signOut;
	
	public void clickOnSigninButton() {
		signInBtn.click();
		
	}

	public void enterValidEmailandPassword() {
			email.sendKeys("nurmnyc@gmail.com");
			password.sendKeys("abc123");
	}

	public void clickOnSignIn() {
		loginInBtn.click();
		
	}

	public void navigateToHomePage() {
		String expected = "nur";
		String actual = nurMo.getText().trim();
		Assert.assertTrue("Word does not match", actual.contains(expected));
		
	}

	public void goToUpperLeftSelectDresses() {
		Dresses.click();
		
	}

	public void SelectSecondHighest() {
		SecondItem.click();
		
	}

	public void addToCart() {
		AddToCart.click();
		
	}

	public void verifyOnCheckout() {
		checkOut.click();
		
	}

	public void signOut() {
		signOut.click();
		
	}

}
