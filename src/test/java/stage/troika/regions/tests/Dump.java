package stage.troika.regions.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Dump {
    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "StageTroikaGorod\\src\\resources\\drivers\\chromedriver.exe");
    } //добавил ChromeDriver

    @BeforeMethod
    public void beforeTest (){
        driver = new ChromeDriver();
            driver.get("https://stage-gorodtroika.rtgsoft.ru");
            driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void dumpTest () throws InterruptedException {
        String SignInLink = "/sign-in";
        driver.findElement(By.xpath("//a[@href='"+SignInLink+"']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys("9645821798");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys("0000");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys("0000");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".sc-jhaWeW")).click();
        driver.findElement(By.cssSelector(".sc-jhaWeW")).sendKeys("0000");
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
        Thread.sleep(1000);
        String hrefLink = "/deal/2117/?erid=5UGfMrea"; // Присваиваю переменной значение ссылки с erid (из банера)
        driver.findElement(By.xpath("//a[@href='"+hrefLink+"']//div[@class='cheep-text']")).click();
        // ↑ Передал значение ссылки в виде переменной в селектор. Что подтверждает наличие метки erid в ссылке на банер.
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='copy-link']")).click();
        Thread.sleep(1000);

        //Нужно отрефакторить этот тест:
        //перенести всё в класс FindLableOnBanner.
        //заменить авторизацию на методы из app.manager.
        //создать метод работы с лейблом.
        //вынести xpath банера и лейбла в переменну.
        //добавить команду поиска и распознавания банеров.

        /*
        Необходимо найти и изучить:
        Передаче строки из буфера обменна в переменную
        Присвоение адреса текущей страницы в переменную

        Следующий тест:
        Дождаться второго банера.
        Проверить ссылку на наличие erid.
        Если ок, завершить тест.
        */
        }
    }
