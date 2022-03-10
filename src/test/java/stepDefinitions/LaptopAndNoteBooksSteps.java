package stepDefinitions;

import java.io.IOException;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaptopAndNoteBooksPageObjects;


public class LaptopAndNoteBooksSteps extends Base{
	
	LaptopAndNoteBooksPageObjects laptopsAndNoteBooks = new LaptopAndNoteBooksPageObjects();
	
	@When("User click on Laptop & NoteBook tab")
	public void user_click_on_laptop_note_book_tab() {
		laptopsAndNoteBooks.clickOnlaptopsAndNoteBooksTab();
	}

	@When("User click on Show all Laptop & NoteBook option")
	public void user_click_on_show_all_laptop_note_book_option() {
		laptopsAndNoteBooks.clickOnlaptopsAndNoteBooksFromList();
	}

	@When("User click on MacBook  item")
	public void user_click_on_mac_book_item() {
		laptopsAndNoteBooks.clickOnMacBookItem();
	}

	@When("User click add to Cart button")
	public void user_click_add_to_cart_button() {
		laptopsAndNoteBooks.clickOnAddToCartButton();
	}

	@Then("User should see a message {string}")
	public void user_should_see_a_message(String string) {
		System.out.println("string from stepDefinition method: " + string);
		laptopsAndNoteBooks.verifySuccessMessage(string);
	}

	@Then("User should see {string} shown on the cart")
	public void user_should_see_tem_s_showed_to_the_cart(String string) {
		laptopsAndNoteBooks.verifyCartTotal(string);
	}

	@And("User click on cart option")
	public void user_click_on_cart_option() throws IOException {
		laptopsAndNoteBooks.clickOnCartOption();
	}

	@And("user click on red X button to remove the item from cart")
	public void user_click_on_red_x_button_to_remove_the_item_from_cart() {
		laptopsAndNoteBooks.clickOnRemoveItemButton();
	}

	@And("item should be removed and cart should show {string}")
	public void item_should_be_removed_and_cart_should_show(String string) {
		laptopsAndNoteBooks.verifyCartTotalAfterRemovingItem(string);
	}
	
}