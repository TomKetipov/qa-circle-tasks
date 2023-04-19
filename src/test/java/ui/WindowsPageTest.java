package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsPageTest extends BaseTest {

    @Test(testName = "Can switch between windows")
    public void canNavigateToNewWindowHandle() {
        app.windowsPage().goToWindowsPage();

        String parentHandle = app.windowsPage().getCurrentWindowHandle();
        app.windowsPage().clickNewWindowLink();

        Set<String> windowHandles = app.windowsPage().getWindowHandles();
        for (String childWindowHandle : windowHandles) {
            if (!parentHandle.equalsIgnoreCase(childWindowHandle)) {
                app.windowsPage().switchToWindow(childWindowHandle);
            }
        }

        Assert.assertEquals(app.windowsPage().getTitle(), "New Window");

        app.windowsPage().switchToWindow(parentHandle);
        Assert.assertEquals(app.windowsPage().getTitle(), "The Internet");
    }
}
