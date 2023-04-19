package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverPageTest extends BaseTest {

    @Test(testName = "Detailed info appears on img hover action")
    public void imgDetailedInfoAppearsOnHover() {
        app.hoversPage().goToHoversPage();

        int figureIndex = 0;
        app.hoversPage().hoverOverFigure(figureIndex);
        Assert.assertTrue(app.hoversPage().getViewProfileLink(figureIndex).isDisplayed());
        Assert.assertTrue(app.hoversPage().getText(app.hoversPage().getNameElement(figureIndex)).contains("user1"));
    }

    @Test(testName = "Can navigate to view profile page")
    public void canNavigateToViewProfilePage() {
        app.hoversPage().goToHoversPage();

        int figureIndex = 2;
        app.hoversPage().hoverOverFigure(figureIndex);
        app.hoversPage().clickOnViewProfileBtn(figureIndex);
        Assert.assertEquals(app.hoversPage().getPageURL(), "https://the-internet.herokuapp.com/users/3");
    }
}
