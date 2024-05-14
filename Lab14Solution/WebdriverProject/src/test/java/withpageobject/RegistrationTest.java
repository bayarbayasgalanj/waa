package withpageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/baysa/git_code/waa/Lab14Solution/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/baysa/git_code/waa/Lab14Solution/chrome-headless-shell-mac-arm64/chrome-headless-shell");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        registrationPage = new RegistrationPage(driver);
        registrationPage.open();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRegistration() {
        registrationPage.clickRegisterButton();
        registrationPage.fillRegistrationForm("John", "Doe", "password123");  // Email is generated within the method now
        String confirmationMessage = registrationPage.getConfirmationMessage();
        assertEquals("Your registration completed", confirmationMessage);
    }
}
