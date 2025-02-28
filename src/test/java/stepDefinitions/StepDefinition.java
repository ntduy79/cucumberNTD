package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;
import setup.Setup;

public class StepDefinition extends Setup {
    @Given ("user visits the portal")
    public void user_visits_the_portal() {
        driver.get("https://wa-tl-dk1.azurewebsites.net/");
    }

    @When ("user inputs {string} and {string}")
    public void userInputsValidAnd(String username, String password) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin(username,password);
    }

    @And("admin navigates to {string}")
    public void userNavigateTo (String area) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(area);
    }

    @When("verify the system support multi language")
    public void verifyTheSystemSupportMultiLanguage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.changeLanguage();
    }


    @Then("the system language is changed to EN")
    public void verifyLanguageChange() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifySystemLanguageIsEN(); // Combined checks
    }

    @Then ("User can see error message")
    public void user_can_see_error_message() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.verifyErrorMessage();

    }
    @Then ("verify the user had been succesfully log in")
    public void user_logs_into_the_dashboard() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.verifyAdminPanelText();
        Thread.sleep(3000);
    }

    @Given ("user visits the portal 2")
    public void user_visits_the_portal2() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
    }

    @Then ("admin user add a new member")
    public void userAddIntoTheDashBoard() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addUser();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}