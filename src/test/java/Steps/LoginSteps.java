package Steps;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    DialogContent dc =new DialogContent();

    @Given("Navigate to Web Page")
    public void navigateToWebPage()
    {
        GWD.getDriver().get("http://10.10.10.79:31193/signin");
        //GWD.getDriver().get("http://192.168.200.160:30003/signin");

    }

    @When("User Enters Email {string} and Password {string} and Click Button")
    public void userEntersEmailAndPasswordAndClickButton(String email, String password)
    {
        dc.findAndSend("email",email);
        dc.findAndSend("password",password);
        dc.findAndClick("loginButton");

    }

    @Then("User Should Login Successfully")
    public void userShouldLoginSuccessfully()
    {
        dc.verifyCurrentUrl("dashboard");
    }

}
