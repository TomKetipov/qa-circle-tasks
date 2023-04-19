package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    protected String getAttributeValue(WebElement element, String attributeKey) {
        waitForElementVisibility(element);
        return element.getAttribute(attributeKey);
    }

    // Waits
    protected void waitForElementVisibility(WebElement elementToBeVisible) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));
    }

    protected void waitForElementToBeClickable(WebElement elementToBeVisible) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeVisible));
    }

    public String getText(WebElement elementToGetText) {
        waitForElementVisibility(elementToGetText);
        return elementToGetText.getText();
    }

    protected void clickElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void typeText(WebElement element, String text) {
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    // Actions
    protected void hoverOverElement(WebElement element) {
        waitForElementVisibility(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
