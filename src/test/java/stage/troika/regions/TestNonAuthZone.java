package stage.troika.regions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNonAuthZone {
    WebDriver driver; //объявил переменную river
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "StageTroikaGorod\\src\\resources\\drivers\\chromedriver.exe");
    } //функция для добавления ChromeDriver в тест.

    @BeforeMethod //начало фикстуры
    public void beforeTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://stage-gorodtroika.rtgsoft.ru");
        driver.manage().window().maximize();
        Thread.sleep(1500);
    }

    @Test
    public void nonAuthWithTroika() //проверка 
    {
        String defaultTextRegionWithTroika = "Пополняйте транспортную карту «Тройка», приобретайте товары и услуги — получайте кешбэк на счет в Городе и меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.";
        String subtitleText = driver.findElement(By.cssSelector(".description-block > .subtitle")).getText();
        defaultTextRegionWithTroika.equals(subtitleText);
    }

    @Test
    public void nonAuthWithOutTroika() throws InterruptedException{
        driver.findElement(By.cssSelector(".geo-btn-desktop")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".geo-btn-desktop")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[data-place='5']")).click();
        String subtitleText = driver.findElement(By.cssSelector(".description-block > .subtitle")).getText();
        String defaultTextRegionWithOutTroika = "Приобретайте товары и услуги, получайте кешбэк на счет в Городе, меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.";
        defaultTextRegionWithOutTroika.equals(subtitleText);
    }
}
