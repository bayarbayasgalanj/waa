package withpageobject.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageThree {
    private WebDriver driver;

    public PageThree(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPaymentDetails(String creditcard, String type) {
        driver.findElement(By.cssSelector("input[placeholder='Creditcard number']")).sendKeys(creditcard);
        driver.findElement(By.cssSelector("select")).sendKeys(type);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
    }
}
