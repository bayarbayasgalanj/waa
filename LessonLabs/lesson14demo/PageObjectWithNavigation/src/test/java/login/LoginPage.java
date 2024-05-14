package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	private WebElement firstName;
	@FindBy(id = "lastname")
	private WebElement lastName;
	@FindBy(id = "address")
	private WebElement address;
	@FindBy(id = "zipcode")
	private WebElement zipCode;
	@FindBy(id = "signup")
	private WebElement submitButton;

	public void open() {
		driver.get ("https://www.kimschiller.com/page-object-pattern-tutorial/");
	}

	public void close() {
		driver.close();
	}

	public void enterName(String firstName, String lastName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);

		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void enterAddress(String address, String zipCode) {
		this.address.clear();
		this.address.sendKeys(address);

		this.zipCode.clear();
		this.zipCode.sendKeys(zipCode);
	}

	public WelcomePage submit() {
		submitButton.click();
		return new WelcomePage(driver);
	}
}

