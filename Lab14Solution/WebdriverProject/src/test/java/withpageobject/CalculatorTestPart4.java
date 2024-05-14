package withpageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class CalculatorTestPart4 {
    private WebDriver driver;
    private CalculatorPagePart4 calculatorPagePart4;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/baysa/git_code/waa/Lab14Solution/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/baysa/git_code/waa/Lab14Solution/chrome-headless-shell-mac-arm64/chrome-headless-shell");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        calculatorPagePart4 = new CalculatorPagePart4(driver);
        calculatorPagePart4.open();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddition() {
        calculatorPagePart4.enterFirstNumber("10");
        calculatorPagePart4.enterSecondNumber("5");
        calculatorPagePart4.performOperation("Add");
        assertEquals("Result: 15", calculatorPagePart4.getResult());
    }

    @Test
    public void testSubtraction() {
        calculatorPagePart4.enterFirstNumber("10");
        calculatorPagePart4.enterSecondNumber("5");
        calculatorPagePart4.performOperation("Subtract");
        assertEquals("Result: 5", calculatorPagePart4.getResult());
    }

    @Test
    public void testMultiplication() {
        calculatorPagePart4.enterFirstNumber("10");
        calculatorPagePart4.enterSecondNumber("5");
        calculatorPagePart4.performOperation("Multiply");
        assertEquals("Result: 50", calculatorPagePart4.getResult());
    }
}
