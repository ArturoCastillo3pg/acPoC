package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class hooks{

    public static WebDriver driver;
    public hooks(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(constants.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

}
