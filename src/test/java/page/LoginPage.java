package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    // WebElement locators

    // WebElement locators for YouTube login
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"floatingPassword\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"idSIButton9\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@id='logo-icon-container']")
    private WebElement youtubeLogo;

    @FindBy(xpath = "//*[@id=\"floatingInput\"]")
    private WebElement usernameField;

    @FindBy(xpath = "/html/body/body/main/form/button/span")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/main/article/div/div/div/div[1]/button")
    private WebElement addButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/span")
    private WebElement pageTitle;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[6]/center/input[2]")
    private WebElement englishText;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/nav/div/ul/li[1]/a")
    private WebElement userManagement;

    @FindBy(xpath = "/html/body/div[1]/body/div/div/nav/div/ul/li[2]/a")
    private WebElement routeManagement;

    @FindBy(xpath = "/html/body/body/main/form/div[3]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"vc3jof\"]/div/div/div")
    private WebElement currentLanguage;

    @FindBy(xpath = "//*[@id=\"SIvCob\"]/a[2]")
    private WebElement changeToEnglish;

    @FindBy(xpath = "/html/body/div[1]/main/article/body/div/div/div/div[1]/button")
    private WebElement addUser;

    // Constructor to initialize PageFactory
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to perform login
    public void doLogin(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void openPage(String area) {
        if (area.equals("User Management")) {
            userManagement.click();
        }
        else if (area.equals("Route Management")) {
            routeManagement.click();
        }

    }

    public void addUser() {
        addUser.click();
    }

    public void changeLanguage() {
        changeToEnglish.click();
    }

    public void verifySystemLanguageIsEN() throws InterruptedException {
        String expectedLanguage = "";
        Assert.assertEquals(expectedLanguage, englishText.getText());
        Thread.sleep(5000);
    }

    // Method to verify error message
    public void verifyErrorMessage() {
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals(expectedErrorMessage, errorMessage.getText());
    }

    // Method to verify page title
    public void verifyAdminPanelText() {
        String expectedTitle = "Hello, admin!";
        Assert.assertEquals(expectedTitle, pageTitle.getText());
    }
}