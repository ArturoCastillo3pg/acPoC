package Step_Definitions;

import commons.ElementEvents;
import helpers.hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.pageElements;

import static helpers.constants.*;


public class webStepDef {
    hooks h = new hooks();
    ElementEvents eL = new ElementEvents();
    pageElements p0 = new pageElements();
   WebDriver driver = h.driver;
   WebElement element;



    @Given("Open web application")
    public void open_web_application() {
        try {
            //use element variable to store the web element
            element = eL.getElementByXpath(p0.imgBrandLogo);
            //call the method isDisplayed to verify if it's true or false
            boolean pageSelected = eL.elementIsDisplayed(element);
            //validate if element is displayed
            Assert.assertTrue(pageSelected);

        }catch (Exception ex){
            System.out.println(ex);
            driver.quit();
        }
    }

    @When("User enter valid Username and Password")
    public void userEnterValidUsernameAndPassword() {
        try{
            //Wait for sign up link
            eL.waitElemetIsVisible(eL.getElementByXpath(p0.lnkSignUp));
            eL.getElementByXpath(p0.lnkSignUp).click();

            //click on log in link
            eL.waitElemetIsVisible(eL.getElementByXpath(p0.lnkLogIn));
            eL.getElementByXpath(p0.lnkLogIn).click();

            //find username txt and send the username
            eL.waitElemetIsVisible(driver.findElement(By.xpath(p0.txtUser)));
            element = eL.getElementByXpath(p0.txtUser);

            element.click();
            element.sendKeys(user);

            //fins pwd txt and send password
            eL.waitElemetIsVisible(driver.findElement(By.xpath(p0.txtPass)));
            element = eL.getElementByXpath(p0.txtPass);

            element.click();
            element.sendKeys(psw);

            //click on login button
            eL.waitElemetIsVisible(driver.findElement(By.xpath(p0.btnLogIn)));
            eL.getElementByXpath(p0.btnLogIn).click();

        }catch (Exception ex){
            System.out.println(ex);
            driver.quit();
        }
    }

    @Then("Navigates on landing page")
    public void navigatesOnLandingPage() throws InterruptedException {
        try {
            eL.waitElemetIsVisible(eL.getElementByXpath(p0.lnkProfile));
            Assert.assertTrue(eL.elementIsDisplayed(eL.getElementByXpath(p0.lnkProfile)));
            eL.sleeper(5);
        }catch (Exception ex){
            System.out.println(ex);
        }
        driver.quit();
    }

    @When("search by {}")
    public void searchBy(String arg0) {
        try{
            //enviar la variable para busqueda
            eL.waitElemetIsVisible(eL.getElementByXpath(p0.txtSearchBar));
            element =  eL.getElementByXpath(p0.txtSearchBar);
            element.click();
            element.sendKeys(arg0);
            element.sendKeys(Keys.ENTER);
        }catch (Exception ex){
            System.out.println(ex);
            driver.quit();
        }
    }

    @Then("Verify that search result is displayed with {}")
    public void verifyThatSearchResultIsDisplayedWith(String item) {
        try{
            eL.waitElemetIsVisible(eL.getElementByXpath(p0.lblSearchHeader));
            String searchText = eL.getText(eL.getElementByXpath(p0.lblSearchHeader));

            Assert.assertTrue(searchText.contains(item));
            driver.quit();
        }catch (Exception ex){
            System.out.println(ex);
            driver.quit();
        }
    }



}

