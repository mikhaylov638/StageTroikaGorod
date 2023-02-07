package stage.troika.regions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthTest {
    WebDriver driver;
    public void setUp() //добавил
    {
        System.setProperty("webdriver.chrome.driver", "StageTroikaGorod\\src\\resources\\drivers\\chromedriver.exe");
    }

    @BeforeMethod //начало фикстуры
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.get("https://stage-gorodtroika.rtgsoft.ru");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.button-atom.Outlined.css-1ujsas3")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys("9645821798");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();//нажал далее
    }

    @Test
    public void auth() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys("0000");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys("0000");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".sc-jhaWeW")).click();
        driver.findElement(By.cssSelector(".sc-jhaWeW")).sendKeys("0000");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".sc-cLQEGU")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".sc-hMFtBS [href='/logout']")).click();
    }
}
