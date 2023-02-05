package stage.troika.regions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Тестирование неавторизованной зоны на регионы:
1. Регион Москва (С тройкой):
    FindText = 'Пополняйте транспортную карту «Тройка»,
                приобретайте товары и услуги — получайте кешбэк на счет в Городе
                и меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.'
2. Регион Самара (Без тройки):
    FindText = 'Приобретайте товары и услуги, получайте кешбэк на счет в Городе,
                меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.'
 */

public class TestNonAuthZone {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void NonAuthWithTroika() throws InterruptedException{
        driver.get("https://stage-gorodtroika.rtgsoft.ru");
        driver.manage().window().setSize(new Dimension(1536, 824));
        Thread.sleep(1500);
        String defaultTextRegionWithTroika = "Пополняйте транспортную карту «Тройка», приобретайте товары и услуги — получайте кешбэк на счет в Городе и меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.";
        String subtitleText = driver.findElement(By.cssSelector(".description-block > .subtitle")).getText();
        defaultTextRegionWithTroika.equals(subtitleText);
    }

    @Test
    public void NonAuthWithOutTroika() throws InterruptedException{
        driver.get("https://stage-gorodtroika.rtgsoft.ru");
        driver.manage().window().setSize(new Dimension(1536, 824));
        Thread.sleep(1500);
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
