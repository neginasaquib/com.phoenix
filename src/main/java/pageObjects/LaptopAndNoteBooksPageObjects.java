package pageObjects;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.Base;
import utilities.Utilities;

public class LaptopAndNoteBooksPageObjects extends Base{
	
	public LaptopAndNoteBooksPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	private WebElement laptopsAndNoteBooksTab;
	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopsAndNotebooks;
	@FindBy(xpath = "//img[@alt='MacBook']")
	private WebElement macBookItem;
	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement addToCartButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;
	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement cartTotal;
	@FindBy(xpath = "//table[@class='table table-striped']//tr//td//button")
	private WebElement removeButton;
	
	public void clickOnlaptopsAndNoteBooksTab() {
		Utilities.waitAndClickElement(laptopsAndNoteBooksTab);
	}
	
	public void clickOnlaptopsAndNoteBooksFromList() {
		Utilities.waitAndClickElement(showAllLaptopsAndNotebooks);
	}
	
	public void clickOnMacBookItem() {
		Utilities.waitAndClickElement(macBookItem);
	}
	
	public void clickOnAddToCartButton() {
		Utilities.waitAndClickElement(addToCartButton);
	}
	
	public void verifySuccessMessage(String strSuccessMessage) {
		String actualSuccessMssg = successMessage.getText();
		String strString = actualSuccessMssg.substring(0, 54);
		Assert.assertEquals(strSuccessMessage, strString);
	}
	
	public void verifyCartTotal(String strCartTotal) {
		String actualCartTotal = cartTotal.getText();
		Assert.assertEquals(strCartTotal, actualCartTotal);
	}
	
	public void clickOnCartOption() throws IOException {
		Utilities.waitAndClickElement(cartTotal);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void clickOnRemoveItemButton() {
		Utilities.waitAndClickElement(removeButton);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyCartTotalAfterRemovingItem(String strCartTotalAfterRemove) {
		String actualCartTotal = cartTotal.getText();
		System.out.println("actual cart total after removing: =======" + actualCartTotal);
		Assert.assertEquals(strCartTotalAfterRemove, actualCartTotal);
		System.out.println(actualCartTotal);
	}
}