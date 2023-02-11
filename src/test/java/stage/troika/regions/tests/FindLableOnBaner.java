package stage.troika.regions.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import javax.xml.xpath.XPath;
import javax.xml.xpath.*;

public class FindLableOnBaner extends TestBase {
    WebDriver driver;

    @Test
    public void findLableAndCopyLink() throws InterruptedException {
        app.clickButtonSignIn();
        app.insertPhone("9645821798");
        Thread.sleep(1500);
        app.insertCapcha("0000");
        Thread.sleep(1500);
        app.insertSMS("0000");
        Thread.sleep(1500);
        app.insertPassword("0000");
        Thread.sleep(1000);
        //driver.findElement(By.cssSelector();
        driver.findElement(By.xpath("//a[@href='/quests']")).click();


    }
}
