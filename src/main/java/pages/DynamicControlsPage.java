package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DynamicControlsPage extends BasePage {
    private final String PAGE_URL = "https://the-internet.herokuapp.com/dynamic_controls";

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "#checkbox")
    WebElement checkboxElement;
    @FindBy(how = How.CSS, using = "#checkbox-example button")
    WebElement checkboxAddRemoveBtn;

    @FindBy(how = How.CSS, using = "#message")
    WebElement message;

    @FindBy(how = How.CSS, using = "#input-example input")
    WebElement inputField;
    @FindBy(how = How.CSS, using = "#input-example button")
    WebElement enableDisableFieldBtn;


    public void goToDynamicContentPage() {
        navigateTo(PAGE_URL);
    }

    public WebElement getMessageElement() {
        waitForElementVisibility(message);
        return message;
    }

    // Checkbox section
    public WebElement getCheckboxElement() {
        waitForElementVisibility(checkboxElement);
        return checkboxElement;
    }

    public void clickAddRemoveCheckboxBtn() {
        clickElement(checkboxAddRemoveBtn);
    }

    // Input field section
    public String getInputValue() {
        return getAttributeValue(inputField, "value");
    }

    public void clickEnableDisableFieldBtn() {
        clickElement(enableDisableFieldBtn);
    }

    public void typeTextInInputField(String text) {
        typeText(inputField, text);
    }
}
