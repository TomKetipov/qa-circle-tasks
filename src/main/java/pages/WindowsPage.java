package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WindowsPage extends BasePage {

    private final String PAGE_URL = "https://the-internet.herokuapp.com/windows";

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[@href='/windows/new']")
    WebElement clickHereLink;

    public void goToWindowsPage() {
        navigateTo(PAGE_URL);
    }

    public void clickNewWindowLink() {
        clickElement(clickHereLink);
    }
}
