package pageObjects;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.Base;
import junit.framework.Assert;
import utilities.Utilities;
public class RegisterAffiliateAccPageObjects extends Base{

	public RegisterAffiliateAccPageObjects() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//aside[@id='column-right']//a[text()='My Account']")
	private WebElement myAccountLink;
	@FindBy(xpath = "//a[text()='Register for an affiliate account']")
	private WebElement registerForAffiliateAccLink;
	@FindBy(xpath = "//input[@id='input-company']")
	private WebElement companyNameTextBox;
	@FindBy(xpath = "//input[@id='input-website']")
	private WebElement websiteNameTextBox;
	@FindBy(xpath = "//input[@id='input-tax']")
	private WebElement taxIdTextBox;
	@FindBy(xpath = "//body/div[@id='account-affiliate']/div[1]/div[1]/form[1]/fieldset[2]/div[2]/div[1]/div[1]/label[1]/input[1]")
	private WebElement chequeRadioButton;
	@FindBy(xpath = "//input[@id='input-cheque']")
	private WebElement ChequePayeeNameTextBox;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement affiliateAccSuccessMessg;
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreeCheckBox;
	
	public void clickOnMyAccountLink() {
		Utilities.waitAndClickElement(myAccountLink);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickOnRegisterForAffiateAcc(String fileName) throws IOException {
		Utilities.scrolldownPage();
		Utilities.highlightelementRedBorderAndTakeScreenshot(registerForAffiliateAccLink, fileName);
		registerForAffiliateAccLink.click();
	}
	public void enterCompanyName(String companyName) {
		companyNameTextBox.sendKeys(companyName);
	}
	public void enterWebsiteName(String websiteName) {
		websiteNameTextBox.sendKeys(websiteName);
	}
	public void enterTaxID(String taxId) {
		taxIdTextBox.sendKeys(taxId);
	}
	public void enterChequePayeeName(String chequePayeeName) {
		ChequePayeeNameTextBox.sendKeys(chequePayeeName);
	}
	
	@SuppressWarnings("deprecation")
	public void verifyChequeRadioButtonIsSelected() {
		chequeRadioButton.click();
		boolean isChequeRadioButtonSelected = chequeRadioButton.isSelected();
		boolean expectedBlm = true;
		try {
			Assert.assertEquals(expectedBlm, isChequeRadioButtonSelected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickAgreeCheckBox() {
		agreeCheckBox.click();
	}
	public void clickOnContinueButton() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		continueButton.click();
	}

	@SuppressWarnings("deprecation")
	public void verifyAffiliateAccSuccessMessage() {
		String expectedMssg = "Success: Your account has been successfully updated.";
		String actualMessage = affiliateAccSuccessMessg.getText();
		try {
			Assert.assertEquals(expectedMssg, actualMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}