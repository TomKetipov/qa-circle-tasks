package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HerokuAppPage extends BasePage {

    private final String PAGE_URL = "https://the-internet.herokuapp.com/drag_and_drop";

    @FindBy(how = How.CSS, using = "#column-a")
    WebElement columnA;

    @FindBy(how = How.CSS, using = "#column-b")
    WebElement columnB;

    public HerokuAppPage(WebDriver driver) {
        super(driver);
    }

    public void goToHerokuAppPage() {
        navigateTo(PAGE_URL);
    }

    public WebElement getColumnA() {
        return columnA;
    }

    public WebElement getColumnB() {
        return columnB;
    }

    public String getTargetElementText() {
        return getText(columnB);
    }


    public String getSourceElementText() {
        return getText(columnA);
    }
}
