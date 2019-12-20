package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webpages.MessengerPage;
import org.testng.Assert;


public class MessengerSD {    // messenger page ve feature fili birlestirilip runner clasa donustugu halidir
    //islemler featurdeki annotationlarin icerigini messenger pagedeki methotlarin cagirip test edilmis

    private MessengerPage messengerPage = new MessengerPage();   //It is connected with Messenger pge

    @Given("^I am on messenger page$")   // It is connected with feature file
    public void setMessengerPage() {
        messengerPage.clickOnMessengerLink();   // Page deki metodlar cagrildi ve test edildi
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(),
                "https://www.messenger.com/");  //SharedSD den metod cagrildi
    }

    @When("^I enter (.+) into (username|password) field on the messenger page$")
    public void enterDataIntoTextField(String value, String textField) {
        switch (textField) {
            case "username":
                messengerPage.enterMail(value);
                break;
            case "password":
                messengerPage.enterPassword(value);
        }
    }

    @And("^I click on login button on messenger page$")
    public void clickOnLoginButton() {

        messengerPage.clickOnSignInButton();
    }

    @Then("^I verify invalid login message on sign in page$")
    public void verifySignInErrorMessage() {

        Assert.assertEquals(messengerPage.getErrorMessage(), "Incorrect Email");
    }
}