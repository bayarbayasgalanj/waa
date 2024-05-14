package withpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
	protected WebDriver driver;

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "one")
	private WebElement oneButton;
	@FindBy(name = "two")
	private WebElement twoButton;
	@FindBy(name = "three")
	private WebElement threeButton;
	@FindBy(name = "four")
	private WebElement fourButton;
	@FindBy(name = "five")
	private WebElement fiveButton;
	@FindBy(name = "six")
	private WebElement sixButton;
	@FindBy(name = "seven")
	private WebElement sevenButton;

	@FindBy(name = "cancel")
	private WebElement clearButton;
	@FindBy(name = "add")
	private WebElement addButton;
	@FindBy(name = "sub")
	private WebElement subtractButton;
	@FindBy(name = "mul")
	private WebElement multipleButton;
	@FindBy(name = "div")
	private WebElement divideButton;
	@FindBy(name = "equal")
	private WebElement equalButton;
	@FindBy(name = "txt")
	private WebElement resultField;

	public void open(String url) {
		driver.get(url);
	}

	public void close() {
		driver.close();
	}

	public String clickOne() {
		oneButton.click();
		return resultField.getAttribute("value");
	}

	public String clickTwo() {
		twoButton.click();
		return resultField.getAttribute("value");
	}

	public String clickThree() {
		threeButton.click();
		return resultField.getAttribute("value");
	}

	public String clickFour() {
		fourButton.click();
		return resultField.getAttribute("value");
	}
	public String clickFive() {
		fiveButton.click();
		return resultField.getAttribute("value");
	}
	public String clickSix() {
		sixButton.click();
		return resultField.getAttribute("value");
	}
	public String clickSeven() {
		sevenButton.click();
		return resultField.getAttribute("value");
	}
	public void clickClear() {
		clearButton.click();
	}

	public String clickEqual() {
		equalButton.click();
		return resultField.getAttribute("value");
	}

	public String clickAdd() {
		addButton.click();
		return resultField.getAttribute("value");
	}

	public String clickSubtract() {
		subtractButton.click();
		return resultField.getAttribute("value");
	}
	public String clickMultiple() {
		multipleButton.click();
		return resultField.getAttribute("value");
	}
	public String clickDivide() {
		divideButton.click();
		return resultField.getAttribute("value");
	}

	public String getResult() {
		return resultField.getAttribute("value");
	}
}
