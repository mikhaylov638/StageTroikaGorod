package stage.troika.regions.tests;

import org.testng.annotations.Test;
import stage.troika.regions.tests.TestBase;

public class TestNonAuthZone extends TestBase {

    @Test
    public void nonAuthWithTroika() //проверка текста в регионе "Москва" (с тройкой)
    {
        app.equalsText("Пополняйте транспортную карту «Тройка», приобретайте товары и услуги — получайте кешбэк на счет в Городе и меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.");
    }

    @Test
    public void nonAuthWithOutTroika() throws InterruptedException{
        app.changeRegion("[data-place='5']");
        app.equalsText("Приобретайте товары и услуги, получайте кешбэк на счет в Городе, меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.");
    } //Проверка текста в регионе "Самара" (без тройки)

    @Test
    public void nonAuthWithTroikaPerm() throws InterruptedException{
        app.changeRegion("[data-place='3']");
        app.equalsText("Пополняйте транспортную карту «Тройка», приобретайте товары и услуги — получайте кешбэк на счет в Городе и меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.");
    }

}
