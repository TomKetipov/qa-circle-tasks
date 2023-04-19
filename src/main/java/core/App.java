package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DynamicControlsPage;
import pages.HoverPage;
import pages.WindowsPage;


public class App {
    private WebDriver driver;
    private HoverPage hoverPage;
    private WindowsPage windowsPage;
    private DynamicControlsPage dynamicControlsPage;

    // instantiating methods for the pages
    public HoverPage hoversPage() {
        if (hoverPage == null) {
            hoverPage = new HoverPage(driver);
        }
        return hoverPage;
    }

    public WindowsPage windowsPage() {
        if (windowsPage == null) {
            windowsPage = new WindowsPage(driver);
        }
        return windowsPage;
    }

    public DynamicControlsPage dynamicControlsPage() {
        if (dynamicControlsPage == null) {
            dynamicControlsPage = new DynamicControlsPage(driver);
        }
        return dynamicControlsPage;
    }

    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void quit() {
        driver.quit();
    }
}
