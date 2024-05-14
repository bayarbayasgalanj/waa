package withpageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class CalculatorTestPart3 {
    private WebDriver driver;
    private CalculatorPagePart3 calculatorPagePart3;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/baysa/git_code/waa/Lab14Solution/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/baysa/git_code/waa/Lab14Solution/chrome-headless-shell-mac-arm64/chrome-headless-shell");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        calculatorPagePart3 = new CalculatorPagePart3(driver);
        calculatorPagePart3.open();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddition() {
        calculatorPagePart3.enterFirstNumber("5");
        calculatorPagePart3.enterSecondNumber("3");
        calculatorPagePart3.clickAdd();
        assertEquals("Result: 8", calculatorPagePart3.getResult());
    }

    @Test
    public void testSubtraction() {
        calculatorPagePart3.enterFirstNumber("5");
        calculatorPagePart3.enterSecondNumber("3");
        calculatorPagePart3.clickSubtract();
        assertEquals("Result: 2", calculatorPagePart3.getResult());
    }

    @Test
    public void testMultiplication() {
        calculatorPagePart3.enterFirstNumber("5");
        calculatorPagePart3.enterSecondNumber("3");
        calculatorPagePart3.clickMultiply();
        assertEquals("Result: 15", calculatorPagePart3.getResult());
    }
}
