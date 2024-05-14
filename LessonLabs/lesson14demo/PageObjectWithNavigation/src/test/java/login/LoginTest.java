package login;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest {

    private static LoginPage loginPage;
    private static WelcomePage welcomePage;

    @BeforeClass
    public static void openTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\waa\\chromedriver.exe");
        // create chrome instance
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        loginPage.open();
    }

    @AfterClass
    public static void closeTheBrowser() {
        loginPage.close();
        if (welcomePage != null)
            welcomePage.close();
    }

    @Test
    public void signUp() {
        loginPage.enterName("Frank", "Brown");
        loginPage.enterAddress("1000 Mainstreet", "52559");

        WelcomePage welcomePage = loginPage.submit();
        welcomePage.verifyHeader("Thank you!");
    }


}