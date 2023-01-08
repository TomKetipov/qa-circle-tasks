package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }

    protected void waitForElementVisibility(WebElement elementToBeVisible) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));
    }

    protected void waitForElementToBeClickable(WebElement elementToBeVisible) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeVisible));
    }

    protected String getText(WebElement elementToGetText) {
        waitForElementVisibility(elementToGetText);
        return elementToGetText.getText();
    }

    protected void switchToIframe(WebElement iFrameElement) {
        waitForElementVisibility(iFrameElement);
        driver.switchTo().frame(iFrameElement);
    }

    public void dragNDropWithLocators(WebElement source, WebElement target) {
        waitForElementToBeClickable(source);
        waitForElementVisibility(target);

        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
    }
}
