package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JQueryPage extends BasePage {

    private final String PAGE_URL = "https://jqueryui.com/droppable/";

    @FindBy(how = How.CSS, using = ".demo-frame")
    WebElement iframe;

    @FindBy(how = How.CSS, using = "#draggable")
    WebElement source;

    @FindBy(how = How.CSS, using = "#droppable")
    WebElement target;

    public JQueryPage(WebDriver driver) {
        super(driver);
    }

    public void goToJQueryPage() {
        navigateTo(PAGE_URL);
    }

    public void switchToDraggableElementsFrame() {
        switchToIframe(iframe);
    }

    public WebElement getSource() {
        return source;
    }

    public WebElement getTarget() {
        return target;
    }

    public String getTargetElementText() {
        return getText(target);
    }
}
