package withpageobject.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTwo {
    private WebDriver driver;

    public PageTwo(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAddress(String street, String city, String zip, String state) {
        driver.findElement(By.cssSelector("input[placeholder='Street']")).sendKeys(street);
        driver.findElement(By.cssSelector("input[placeholder='City']")).sendKeys(city);
        driver.findElement(By.cssSelector("input[placeholder='Zip']")).sendKeys(zip);
        driver.findElement(By.cssSelector("select")).sendKeys(state);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
    }
}
