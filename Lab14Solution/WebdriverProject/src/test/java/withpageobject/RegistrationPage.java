package withpageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://demo.nopcommerce.com/");
    }

    public void clickRegisterButton() {
        driver.findElement(By.className("ico-register")).click();
    }

    public void fillRegistrationForm(String firstName, String lastName, String password) {
        // Generate unique email
        String email = createUniqueEmail();

        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.id("register-button")).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(By.className("result")).getText();
    }

    private String createUniqueEmail() {
        String email = "@gmail.com";
        String name = "frank" + createRandomNumber();
        return name + email;
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 5000 + 1);
    }
}
