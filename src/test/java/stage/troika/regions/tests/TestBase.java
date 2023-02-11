package stage.troika.regions.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import stage.troika.regions.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod //начало фикстуры
    public void beforeTest(){
        app.linkAndMaximizeScreen();
    }

    @AfterMethod //окончание фикстуры
    public void tearDown(){
        app.closeWindow();
    }

}
