package stage.troika.regions;

import org.testng.annotations.Test;

public class AuthTest extends TestBase {

    @Test
    public void auth() throws InterruptedException {
        clickButtonSignIn();
        insertPhone("9645821798");
        Thread.sleep(1500);
        insertCapcha("0000");
        Thread.sleep(1500);
        insertSMS("0000");
        Thread.sleep(1500);
        insertPassword("0000");
        Thread.sleep(1000);
        exitFromAccount();
    }

}
