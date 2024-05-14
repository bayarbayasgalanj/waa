package withpageobject;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	private static CalculatorPage page;

	@Before
	public void createWebDriver() {
		// set path to chromedriver.exe
//		System.setProperty("webdriver.chrome.driver", "C:\\waa\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/Users/baysa/git_code/waa/Lab14Solution/chromedriver-mac-arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Users/baysa/git_code/waa/Lab14Solution/chrome-headless-shell-mac-arm64/chrome-headless-shell");
		options.addArguments("--remote-allow-origins=*");
	    page = PageFactory.initElements(new ChromeDriver(options), CalculatorPage.class);
	    page.open("http://www.rekenmachine-calculator.nl/");
	  }

	  @AfterClass
	  public static void closeTheBrowser() {
	    page.close();
	  }

	  @Test
	  public void oneAndFour() {
	    page.clickOne();
	    page.clickAdd();
	    page.clickFour();
	    assertThat(page.getResult(),  is("1+4"));
	    page.clickEqual();
	    assertThat(page.getResult(),  is("5"));
	    page.clickClear();
	  }

	@Test
	public void multiplySevenAndThree() {
		page.clickSeven();
		page.clickMultiple();
		page.clickThree();
		assertThat(page.getResult(),  is("7*3"));
		page.clickEqual();
		assertThat(page.getResult(),  is("21"));
		page.clickClear();
	}
	@Test
	public void divideSixByTwo() {
		page.clickSix();
		page.clickDivide();
		page.clickTwo();
		assertThat(page.getResult(),  is("6/2"));
		page.clickEqual();
		assertThat(page.getResult(),  is("3"));
		page.clickClear();
	}
	@Test
	public void subtractFiveFromSeven() {
		page.clickSeven();
		page.clickSubtract();
		page.clickFive();
		assertThat(page.getResult(),  is("7-5"));
		page.clickEqual();
		assertThat(page.getResult(),  is("2"));
		page.clickClear();
	}
}