package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JQueryPageTest extends BaseTest {

    @Test(testName = "Can drag a given source element to a target element")
    public void canDragSourceElementToTarget() {
        app.jQueryPage().goToJQueryPage();
        app.jQueryPage().switchToDraggableElementsFrame();
        app.jQueryPage().dragNDropWithLocators(app.jQueryPage().getSource(), app.jQueryPage().getTarget());

        Assert.assertEquals(app.jQueryPage().getTargetElementText(), "Dropped!");
    }
}
