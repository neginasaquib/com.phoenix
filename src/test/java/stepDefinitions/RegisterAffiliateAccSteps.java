package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import core.Base;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.RegisterAffiliateAccPageObjects;
import utilities.Utilities;

public class RegisterAffiliateAccSteps extends Base {
	
	RegisterAffiliateAccPageObjects registerAffiliate = new RegisterAffiliateAccPageObjects();

	@When("User click on Register for an Affiliate Account link")
	public void user_click_on_register_for_an_affiliate_account_link() throws IOException {
		registerAffiliate.clickOnMyAccountLink();
		registerAffiliate.clickOnRegisterForAffiateAcc("Affiliate Account Link");
		logger.info("Register for an Affiliate Account link was clicked successfully");
	}

	@When("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(DataTable dataTable) {
		List<Map<String, String>> editAffilate = dataTable.asMaps(String.class, String.class);
		registerAffiliate.enterCompanyName(editAffilate.get(0).get("company"));
		registerAffiliate.enterWebsiteName(editAffilate.get(0).get("website"));
		registerAffiliate.enterTaxID(editAffilate.get(0).get("taxID"));
		registerAffiliate.enterChequePayeeName(editAffilate.get(0).get("paymentMethod"));
		registerAffiliate.verifyChequeRadioButtonIsSelected();
	}

	@When("User check on About us check box")
	public void user_check_on_about_us_check_box() {
		registerAffiliate.clickAgreeCheckBox();
	}

	@When("User click on Continue button")
	public void user_click_on_continue_button() {
		registerAffiliate.clickOnContinueButton();
	}

	@Then("User should see a success message")
	public void user_should_see_a_success_message() throws IOException {
		registerAffiliate.verifyAffiliateAccSuccessMessage();
		Utilities.takeScreenShot("success message");
	}
}