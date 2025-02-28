package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; // Import ChromeDriver
import java.time.Duration;

public class Setup {
    public WebDriver driver;

    public Setup() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}