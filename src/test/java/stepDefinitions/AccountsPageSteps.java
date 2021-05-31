package stepDefinitions;

import com.pages.actions.MyAccountPage;
import com.pages.actions.LoginPage;
import com.genericUtils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage();
    private MyAccountPage accountsPage=new MyAccountPage();


    @Given("User logs in to app with credentials")
    public void user_logs_in_to_app_with_credentials(io.cucumber.datatable.DataTable credentialTable) {
        List<Map<String, String>> credentialTableList = credentialTable.asMaps();
        String userName = credentialTableList.get(0).get("username");
        String password = credentialTableList.get(0).get("password");

        accountsPage.getDriver().get(ConfigReader.getProperty("url"));
        loginPage.doLogin(userName, password);

    }

    @Given("user is on accounts page")
    public void user_is_on_accounts_page() {

        System.out.println("Page title is: " + loginPage.getPageTitle());
    }

    @Then("user gets accounts options")
    public void user_gets_accounts_options(io.cucumber.datatable.DataTable expectedAccountSectionTable) {
        ArrayList<String> actualAccountSectionTable = accountsPage.myAccountDetails();
        System.out.println("Actual account section list: " + actualAccountSectionTable);
        Assert.assertTrue(expectedAccountSectionTable.asList().containsAll(actualAccountSectionTable));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer optionCounts) {
        Assert.assertTrue(accountsPage.getOptionsCount() == optionCounts);
    }


}
