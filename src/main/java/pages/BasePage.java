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

    public void html5Drag(WebElement source, WebElement target) {
        waitForElementToBeClickable(source);
        waitForElementVisibility(target);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", source, target);
    }
}
