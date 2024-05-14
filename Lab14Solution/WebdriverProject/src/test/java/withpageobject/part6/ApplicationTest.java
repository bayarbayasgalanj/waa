package withpageobject.part6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {
    private WebDriver driver;
    private PageOne pageOne;
    private PageTwo pageTwo;
    private PageThree pageThree;
    private PageFour pageFour;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/baysa/git_code/waa/Lab14Solution/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/baysa/git_code/waa/Lab14Solution/chrome-headless-shell-mac-arm64/chrome-headless-shell");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000");
        pageOne = new PageOne(driver);
        pageTwo = new PageTwo(driver);
        pageThree = new PageThree(driver);
        pageFour = new PageFour(driver);
    }

    @Test
    public void testCompleteForm() {
        pageOne.enterDetails("John", "Doe", "Programmer");
        pageTwo.enterAddress("123 Baker", "Townsville", "12345", "TX");
        pageThree.enterPaymentDetails("123456789012", "Visa");
        assertEquals("Thank you for your order!", pageFour.getConfirmationMessage());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
