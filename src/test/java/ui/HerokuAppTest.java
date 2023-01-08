package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest extends BaseTest {

    @Test(testName = "Can drag element a to element b")
    public void canDragElementAToElementB() {
        app.herokuAppPage().goToHerokuAppPage();
        app.herokuAppPage().dragNDropWithLocators(app.herokuAppPage().getColumnA(), app.herokuAppPage().getColumnB());
        Assert.assertEquals(app.herokuAppPage().getTargetElementText(), "A");
        Assert.assertEquals(app.herokuAppPage().getSourceElementText(), "B");
    }
}
