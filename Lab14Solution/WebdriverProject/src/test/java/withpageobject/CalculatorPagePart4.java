package withpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPagePart4 {
    private WebDriver driver;

    public CalculatorPagePart4(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://localhost:3000"); // Adjust the URL based on your local setup
    }

    public void enterFirstNumber(String number) {
        WebElement firstNumberInput = driver.findElement(By.cssSelector("input[type='number']:nth-child(1)"));
        firstNumberInput.clear();
        firstNumberInput.sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        WebElement secondNumberInput = driver.findElement(By.cssSelector("input[type='number']:nth-child(2)"));
        secondNumberInput.clear();
        secondNumberInput.sendKeys(number);
    }

    public void performOperation(String operation) {
        driver.findElement(By.xpath("//button[text()='" + operation + "']")).click();
    }

    public String getResult() {
        return driver.findElement(By.tagName("h1")).getText();
    }
}
