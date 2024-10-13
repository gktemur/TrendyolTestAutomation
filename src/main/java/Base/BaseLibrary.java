package Base;

import org.testng.Assert;

public class BaseLibrary extends TestData {
    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void assertEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }
}
