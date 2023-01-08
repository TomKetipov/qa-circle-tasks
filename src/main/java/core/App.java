package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HerokuAppPage;
import pages.JQueryPage;


public class App {
    private WebDriver driver;
    private static final String RESOURCES_PATH = "src/main/resources/drivers/";

    // Driver Paths
    private final String WINDOWS_CHROME_DRIVER_PATH = RESOURCES_PATH + "windows-chromedriver.exe";
    private final String LINUX_CHROME_DRIVER_PATH = RESOURCES_PATH + "linux-chromedriver-108";

    private JQueryPage jQueryPage;
    private HerokuAppPage herokuAppPage;

    // instantiating methods for the pages
    public JQueryPage jQueryPage() {
        if (jQueryPage == null) {
            jQueryPage = new JQueryPage(driver);
        }
        return jQueryPage;
    }

    public HerokuAppPage herokuAppPage() {
        if (herokuAppPage == null) {
            herokuAppPage = new HerokuAppPage(driver);
        }
        return herokuAppPage;
    }

    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", LINUX_CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void quit() {
        driver.quit();
    }
}
