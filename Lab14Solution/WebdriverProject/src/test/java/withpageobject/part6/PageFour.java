package withpageobject.part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFour {
    private WebDriver driver;

    public PageFour(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        return driver.findElement(By.tagName("h3")).getText();
    }
}
