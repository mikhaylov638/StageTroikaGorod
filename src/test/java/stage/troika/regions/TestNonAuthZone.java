package stage.troika.regions;

import org.testng.annotations.Test;

public class TestNonAuthZone extends TestBase {

    @Test
    public void nonAuthWithTroika() //проверка текста в регионе "Москва" (с тройкой)
    {
        equalsText("Пополняйте транспортную карту «Тройка», приобретайте товары и услуги — получайте кешбэк на счет в Городе и меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.");
    }

    @Test
    public void nonAuthWithOutTroika() throws InterruptedException{
        changeRegion("[data-place='5']");
        equalsText("Приобретайте товары и услуги, получайте кешбэк на счет в Городе, меняйте накопленные бонусы на скидки и подарки магазинов и сервисов.");
    } //Проверка текста в регионе "Самара" (без тройки)

}
