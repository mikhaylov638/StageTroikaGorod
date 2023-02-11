package stage.troika.regions.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "StageTroikaGorod\\src\\resources\\drivers\\chromedriver.exe");
    } //добавил ChromeDriver

    public void clickButtonSignIn() {
       driver.findElement(By.xpath("//a[@href='/sign-in']")).click();
       driver.findElement(By.cssSelector(".sc-dvpmds")).click();
    } //клик на кнопку "Вход"

    public void insertPhone(String phoneNumber) {
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод номер, далее

    public void insertCapcha(String capcha) {
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys(capcha);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод капчи, далее

    public void insertSMS(String smsCode) {
        driver.findElement(By.cssSelector(".sc-dvpmds")).click();
        driver.findElement(By.cssSelector(".sc-dvpmds")).sendKeys(smsCode);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод смс-кода, далее

    public void insertPassword(String password) {
        driver.findElement(By.cssSelector(".sc-jhaWeW")).click();
        driver.findElement(By.cssSelector(".sc-jhaWeW")).sendKeys(password);
        driver.findElement(By.cssSelector(".sc-dHIava")).click();
    } //ввод пароля, далее

    public void exitFromAccount() throws InterruptedException {
        driver.findElement(By.cssSelector(".sc-cLQEGU")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".sc-hMFtBS [href='/logout']")).click();
    } //открытие бокового меню, нажатее кнопки "Выход"

    public void equalsText(String defaultTextRegionTroika) {
        String defaultTextRegionWithOutTroika = defaultTextRegionTroika;
        String subtitleText = driver.findElement(By.cssSelector(".description-block > .subtitle")).getText();
        defaultTextRegionWithOutTroika.equals(subtitleText);
    } //создал метод сравнения текста. Вывел эталонный текст в переменную

    public void changeRegion(String selectorRegion) throws InterruptedException {
        driver.findElement(By.cssSelector(".geo-btn-desktop")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".geo-btn-desktop")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(selectorRegion)).click();
    } //Вывел css селектор региона в переменную

    public void closeWindow() {
        driver.quit();
    } //метод для tearDawn

    public void linkAndMaximizeScreen() {
        driver = new ChromeDriver();
        driver.get("https://stage-gorodtroika.rtgsoft.ru");
        driver.manage().window().maximize();
    } //метод для beforeTests
}
