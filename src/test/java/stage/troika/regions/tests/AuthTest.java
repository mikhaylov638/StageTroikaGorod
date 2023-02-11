package stage.troika.regions.tests;

import org.testng.annotations.Test;
import stage.troika.regions.tests.TestBase;

public class AuthTest extends TestBase {

    @Test
    public void auth() throws InterruptedException {
        app.clickButtonSignIn();
        app.insertPhone("9645821798");
        Thread.sleep(1500);
        app.insertCapcha("0000");
        Thread.sleep(1500);
        app.insertSMS("0000");
        Thread.sleep(1500);
        app.insertPassword("0000");
        Thread.sleep(1000);
        app.exitFromAccount();
    }

}
