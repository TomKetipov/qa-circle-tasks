package core;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected App app;

    @BeforeMethod
    public void setup() {
        app = new App();
        app.startBrowser();
    }

//    @AfterMethod
//    public void tearDown() {
//        app.quit();
//    }
}
