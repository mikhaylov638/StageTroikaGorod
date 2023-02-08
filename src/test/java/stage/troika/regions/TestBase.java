package stage.troika.regions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;

    public void setUp() //добавил ChromeDriver
    {
        System.setProperty("webdriver.chrome.driver", "StageTroikaGorod\\src\\resources\\drivers\\chromedriver.exe");
    }

    @BeforeMethod //начало фикстуры
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.get("https://stage-gorodtroika.rtgsoft.ru");
        driver.manage().window().maximize();
    }

    @AfterMethod //окончание фикстуры
    public void tearDown(){
        driver.quit();
    }


    //Методы для проверок регионов.
    protected void clickButtonSignIn() {
        driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.button-atom.Outlined.css-1ujsas3")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
    } //клик на кнопку "Вход"

    protected void insertPhone(String phoneNumber) {
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод номер, далее

    protected void insertCapcha(String capcha) {
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys(capcha);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод капчи, далее

    protected void insertSMS(String smsCode) {
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys(smsCode);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод смс-кода, далее

    protected void insertPassword(String password) {
        driver.findElement(By.cssSelector(".sc-jhaWeW")).click();
        driver.findElement(By.cssSelector(".sc-jhaWeW")).sendKeys(password);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод пароля, далее

    protected void exitFromAccount() throws InterruptedException {
        driver.findElement(By.cssSelector(".sc-cLQEGU")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".sc-hMFtBS [href='/logout']")).click();
    } //открытие бокового меню, нажатее кнопки "Выход"

    protected void equalsText(String defaultTextRegionTroika) {
        String defaultTextRegionWithOutTroika = defaultTextRegionTroika;
        String subtitleText = driver.findElement(By.cssSelector(".description-block > .subtitle")).getText();
        defaultTextRegionWithOutTroika.equals(subtitleText);
    } //создал метод сравнения текста. Вывел эталонный текст в переменную

    protected void changeRegion(String selectorRegion) throws InterruptedException {
        driver.findElement(By.cssSelector(".geo-btn-desktop")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".geo-btn-desktop")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(selectorRegion)).click();
    } //Вывел css селектор региона в переменную
}
