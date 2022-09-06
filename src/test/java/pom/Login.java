package pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Login {
	WebDriver driver;

	@CacheLookup
	@FindBy(id = "ap_email")
	WebElement emailid;

	@CacheLookup
	@FindBy(id = "ap_password")
	WebElement passwd;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-flyout-ya-signin\']/a/span")
	WebElement signinpage;

	@CacheLookup
	@FindBy(id = "continue")
	WebElement Continuebtn;

	@CacheLookup
	@FindBy(id = "signInSubmit")
	WebElement signinbtn;

	@CacheLookup
	@FindBy(partialLinkText = "Forgotten password?")
	WebElement forgotPasswordLink;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-link-accountList\']/span")
	WebElement Accountlist;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-al-your-account\']/a[3]/span")
	WebElement wishlist;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-xshop\']/a[11]")
	WebElement accountpay;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-xshop\']/a[9]")
	WebElement newrelease;

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;

	@CacheLookup
	@FindBy(id = "nav-search-submit-button")
	WebElement searchbtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='search']/span/div/h1/div/div[1]/div/div/span[1]")
	WebElement searchresults;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'p_72/1318476031\']/span/a/section/i")
	WebElement custreview;

	// *[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img
	// *[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span/text()
	// *[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span/text()
	// Samsung Galaxy M13 (Aqua Green, 6GB, 128GB Storage) | 6000mAh Battery | Upto
	// 12GB RAM with RAM Plus
	////*[contains(text(),'ABC')]
	////*[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span
	//*[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img
	//*[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span
	//*[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span
	//*[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div
	@CacheLookup
	@FindBy(xpath="//div[@class='aok-relative']span[1]")
	//"//*[@id=\'search\']/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
	WebElement FirstProduct;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginWithCredentials(String username, String password) {

		Reporter.log("username = " + username);
		Reporter.log("password = " + password);
		emailid.clear();
		emailid.sendKeys(username);
		Continuebtn.click();

		passwd.clear();
		passwd.sendKeys(password);

	}

	public void InvalidloginWithCredentials(String username, String password) {

		Reporter.log("username = " + username);
		Reporter.log("password = " + password);
		emailid.clear();
		emailid.sendKeys(username);
		Continuebtn.click();

	}

	public void forgotPassword(String username) {
		forgotPasswordLink.click();
	}

	public void Hover_Accounts() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Accountlist).perform();
		signinpage.click();

	}

	public void Accountwishlist() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Accountlist).perform();
		wishlist.click();

	}

	public void Account_Pay_Module() {
		accountpay.click();
	}

	public void New_Release_Module() {
		newrelease.click();
	}

	public void searchtextbox() {
		searchbox.click();
		searchbox.sendKeys("mi mobile");
		searchbtn.click();
		Reporter.log("navigated to search box successfully ");
	}

	public void result_text() {
		String expected = "1-16 of 80 results for";
		String result = searchresults.getText();
		String failureMessage = " results does not match";
		System.out.println(result);
		assertTrue(result.equals(expected), failureMessage + ",");
		Reporter.log(result + " mi mobile");
		Reporter.log(expected + " mi mobile");
	}

	public void CustomerReview() {
		custreview.click();
		Reporter.log("4 star customer reveiew clicked successfully");
	}

	public void Select_product()
	{
		FirstProduct.click();
		Reporter.log("First mi mobile product selected successfully with 4 star rating");
	}
}
