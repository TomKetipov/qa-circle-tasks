package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsPageTest extends BaseTest {
    @Test(testName = "Can Add/Remove checkboxes")
    public void canAddRemoveCheckboxElements() {
        app.dynamicControlsPage().goToDynamicContentPage();
        app.dynamicControlsPage().clickAddRemoveCheckboxBtn();
        Assert.assertTrue(app.dynamicControlsPage().getMessageElement().isDisplayed());

        app.dynamicControlsPage().clickAddRemoveCheckboxBtn();
        Assert.assertTrue(app.dynamicControlsPage().getCheckboxElement().isDisplayed());
    }

    @Test(testName = "Can Enable/Disable text field element")
    public void canEnableDisableTextElement() {
        app.dynamicControlsPage().goToDynamicContentPage();
        app.dynamicControlsPage().clickEnableDisableFieldBtn();
        Assert.assertTrue(app.dynamicControlsPage().getMessageElement().isDisplayed());
        Assert.assertEquals(app.dynamicControlsPage().getText(app.dynamicControlsPage().getMessageElement()), "It's enabled!");

        String testData = "QA Circle";

        app.dynamicControlsPage().typeTextInInputField(testData);
        app.dynamicControlsPage().clickEnableDisableFieldBtn();
        Assert.assertTrue(app.dynamicControlsPage().getMessageElement().isDisplayed());
        Assert.assertEquals(app.dynamicControlsPage().getText(app.dynamicControlsPage().getMessageElement()), "It's disabled!");
        Assert.assertEquals(app.dynamicControlsPage().getInputValue(), testData);
    }
}
