package withpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPagePart3 {
    private WebDriver driver;

    public CalculatorPagePart3(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://localhost:3000");
    }

    public void enterFirstNumber(String number) {
        WebElement firstNumberInput = driver.findElement(By.cssSelector("input[type='number']:nth-child(1)"));
        firstNumberInput.sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        WebElement secondNumberInput = driver.findElement(By.cssSelector("input[type='number']:nth-child(2)"));
        secondNumberInput.sendKeys(number);
    }

    public void clickAdd() {
        driver.findElement(By.xpath("//button[text()='Add']")).click();
    }

    public void clickSubtract() {
        driver.findElement(By.xpath("//button[text()='Subtract']")).click();
    }

    public void clickMultiply() {
        driver.findElement(By.xpath("//button[text()='Multiply']")).click();
    }

    public String getResult() {
        return driver.findElement(By.tagName("h2")).getText();
    }
}
