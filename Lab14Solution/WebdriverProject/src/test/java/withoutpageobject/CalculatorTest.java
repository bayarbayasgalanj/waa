package withoutpageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	private WebDriver driver;

	@Before
	public void createWebDriver() {
		// set path to chromedriver.exe
//		System.setProperty("webdriver.chrome.driver", "C:\\waa\\chromedriver.exe");
		// create chrome instance

		System.setProperty("webdriver.chrome.driver", "/Users/baysa/git_code/waa/Lab14Solution/chromedriver-mac-arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Users/baysa/git_code/waa/Lab14Solution/chrome-headless-shell-mac-arm64/chrome-headless-shell");
//		driver = new ChromeDriver();
		options.addArguments("--remote-allow-origins=*");
		// create chrome instance
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}

	@After
	public void closeWebDriver() {
		driver.close();
	}

	@Test
	public void oneAndFour() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("one"));
		button.click();
		button = driver.findElement(By.name("add"));
		button.click();
		button = driver.findElement(By.name("four"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("1+4"));
		button = driver.findElement(By.name("equal"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("5"));
	}
	@Test
	public void multiplySevenAndThree() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("seven"));
		button.click();
		button = driver.findElement(By.name("mul"));
		button.click();
		button = driver.findElement(By.name("three"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("7*3"));
		button = driver.findElement(By.name("equal"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("21"));
	}

	@Test
	public void divideTenByTwo() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("one"));
		button.click();
		button = driver.findElement(By.name("zero"));
		button.click();
		button = driver.findElement(By.name("div"));
		button.click();
		button = driver.findElement(By.name("two"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("10/2"));
		button = driver.findElement(By.name("equal"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("5"));
	}

	@Test
	public void subtractFiveFromEight() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("eight"));
		button.click();
		button = driver.findElement(By.name("sub"));
		button.click();
		button = driver.findElement(By.name("five"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("8-5"));
		button = driver.findElement(By.name("equal"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("3"));
	}

}
