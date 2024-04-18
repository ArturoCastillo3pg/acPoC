package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helpers.hooks;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class ElementEvents{
    WebDriver driver = hooks.driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public WebElement getElementByXpath(String xPath){
        if(wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
        WebElement xpathElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));

        return  xpathElement;
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public boolean elementIsDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void waitElemetIsVisible(WebElement element){
        if(wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        }
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sleeper(int seconds) throws InterruptedException {
        seconds *= 1000;
        Thread.sleep(seconds);
    }

    public static String loadFile() throws  Exception{
        String content = new
                String(Files.readAllBytes(Paths.get(
                        System.getProperty("user.dir") +"/inputData/jsonFiles/clientInfo.json")));
        return content;
    }

}
