package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HoverPage extends BasePage {
    private final String PAGE_URL = "https://the-internet.herokuapp.com/hovers";

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='figure']")
    List<WebElement> imageContainers;

    @FindBy(how = How.CSS, using = "h5")
    List<WebElement> nameList;

    @FindBy(how = How.XPATH, using = "//a[starts-with(@href,'/users/')]")
    List<WebElement> viewProfileBtns;

    public void goToHoversPage() {
        navigateTo(PAGE_URL);
    }

    public void hoverOverFigure(int figureIndex) {
        int index = 0;
        for (WebElement imageContainer : imageContainers) {
            if (index == figureIndex) {
                hoverOverElement(imageContainer);
                break;
            }
            index++;
        }
    }

    public void clickOnViewProfileBtn(int figureIndex) {
        int index = 0;
        for (WebElement viewProfileBtn : viewProfileBtns) {
            if (index == figureIndex) {
                hoverOverFigure(figureIndex);
                clickElement(viewProfileBtn);
                break;
            }
            index++;
        }
    }

    public WebElement getViewProfileLink(int figureIndex) {
        if (viewProfileBtns.size() >= figureIndex && figureIndex >= 0) {
            return viewProfileBtns.get(figureIndex);
        } else {
            throw new RuntimeException("Invalid view-profile btn index. Max index: " + viewProfileBtns.size());
        }
    }

    public WebElement getNameElement(int figureIndex) {
        if (nameList.size() >= figureIndex && figureIndex >= 0) {
            return nameList.get(figureIndex);
        } else {
            throw new RuntimeException("Invalid name element index. Max index: " + nameList.size());
        }
    }
}
