package pageObjects;

public class pageElements {

    //Home
    public static String lnkSignUp = "//*[contains(text(),'SIGN UP')]//ancestor::a";
    public static String lnkLogIn = "//*[contains(text(),'Log in')]";
    public static String txtSearchBar = "//input[@name='s']";
    public static String lblSearchHeader = "//*[contains(text(),'Deals we found')]";
    public static String lnkProfile = "//*[contains(text(),'PROFILE')]";

    //Login page
    public static String txtUser = "//*[@name='username' and @aria-label='Email Address']";
    public static String txtPass = "(//*[@name='password' and @aria-label='Password'])[3]";
    public static String btnLogIn = "//*[@aria-label='Submit button' and @value='Login']";
    public static String imgBrandLogo = "//img[contains(@class,'header__logo')]";
}