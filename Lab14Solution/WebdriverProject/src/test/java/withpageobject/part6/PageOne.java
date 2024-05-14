package withpageobject.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOne {
    private WebDriver driver;

    public PageOne(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String firstname, String lastname, String profession) {
        driver.findElement(By.cssSelector("input[placeholder='FirstName']")).sendKeys(firstname);
        driver.findElement(By.cssSelector("input[placeholder='Lastname']")).sendKeys(lastname);
        driver.findElement(By.cssSelector("select")).sendKeys(profession);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
    }
}


