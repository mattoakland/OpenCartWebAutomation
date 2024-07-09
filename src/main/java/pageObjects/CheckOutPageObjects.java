package pageObjects;


import com.mysql.cj.protocol.result.AbstractResultsetRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.DriverFactory;
import testBase.TestBase;

public class CheckOutPageObjects extends TestBase  {

	/*Checkout Options Tab Objects*/
	By register_account_radio = By.xpath("//input[@type='radio' and @value='register']");
	By guest_checkout_radio = By.xpath("//input[@type='radio' and @value='guest']");
	By continueButton_checkoutOptions = By.xpath("//input[@type='button' and @id='button-account']");
	By email_txt_field_FromCheckoutOptions = By.xpath("//input[@type='text' and @id='input-email']");
	By password_txt_field = By.xpath("//input[@type='password' and @id='input-password']");
	By login_button = By.xpath("//input[@type='button' and @id='button-login']");

	/*Billing Details Tab Objects*/
	By firstName_txt_field = By.xpath("//input[@type='button' and @id='button-login']");
	By lastName_txt_field = By.xpath("//input[@type='button' and @id='button-login']");
	By email_txt_field_FromPersonalDetails = By.xpath("//input[@type='button' and @id='button-login']");
	By telephone_txt_field = By.xpath("//input[@type='button' and @id='button-login']");
	By address1_txt_field = By.xpath("//input[@type='button' and @id='button-login']");
	By city_txt_field = By.xpath("//input[@type='button' and @id='button-login']");
	By postCode_txt_field = By.xpath("//input[@type='button' and @id='button-login']");
	By country_dropdown = By.xpath("//input[@type='button' and @id='button-login']");
	By region_state_dropdown = By.xpath("//input[@type='button' and @id='button-login']");
	By sameBillingAddress_checkbox = By.xpath("//input[@type='checkbox' and @id='shipping_address']");
	By subscribe_checkbox = By.xpath("//input[@type='checkbox' and @id='newsletter']");
	By continue_button_registerAcc = By.xpath("//input[@type='button' and @id='button-register']");
	By continue_button_guest = By.xpath("//input[@type='button' and @id='button-guest']");

	/*Checkout Options Tab Functions*/
	public void chooseCheckoutOption(String option) {
		if(option.contains("register")){
			click_custom(DriverFactory.getInstance().getDriver().findElement(register_account_radio), "Register Checkout Radio Button");
		}else if(option.contains("guest")){
			click_custom(DriverFactory.getInstance().getDriver().findElement(guest_checkout_radio), "Guest Checkout Radio Button");
		}else{
			click_custom(DriverFactory.getInstance().getDriver().findElement(guest_checkout_radio), "Guest Checkout Radio Button");
		}
	}
	public void clickContinue_FromCheckoutOptions() {
		//DriverFactory.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(continueButton_checkoutOptions));
		click_custom(DriverFactory.getInstance().getDriver().findElement(continueButton_checkoutOptions), "Continue Button from CheckoutOption_Accordion");
	}
	public void userLogin(String email, String password) {
		//send email
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(email_txt_field_FromCheckoutOptions), "Email TXT Field", email);
		//send password
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(password_txt_field), "Password TXT Field", password);
		click_custom(DriverFactory.getInstance().getDriver().findElement(login_button), "Login Button from Checkout Options");
	}

	/*Billing Details Tab Functions*/
	public void sendPersonalDetails(String fName,String lName, String email, String telephone) {
		//send first name text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(firstName_txt_field), "FirstName TXT Field", fName);
		//send last name text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(lastName_txt_field), "LastName TXT Field", lName);
		//send email text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(email_txt_field_FromPersonalDetails), "Email TXT Field", email);
		//send telephone text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(telephone_txt_field), "Telephone TXT Field", telephone);
	}
	public void sendAddressDetails(String address1,String city,String postCode, String country, String state) throws Throwable {
		//send address 1 text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(address1_txt_field), "Address TXT Field", address1);
		//send city text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(city_txt_field), "City TXT Field", city);
		//send post code text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(postCode_txt_field), "Postcode TXT Field", postCode);
		//choose country dropdown
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(country_dropdown), "Country Dropdown", country);
		//choose Region/State dropdown
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(region_state_dropdown), "Region/State Dropdown", state);
	}

	public void choose_sameBillingAddress(boolean sameAddress) {
		WebElement checkbox = DriverFactory.getInstance().getDriver().findElement(sameBillingAddress_checkbox);
		if(sameAddress) {
			// Verify if the checkbox is checked
			if (checkbox.isSelected()) {
				System.out.println("The checkbox is already checked.");
			} else {
				// Check the checkbox if it is not checked
				checkbox.click();
				System.out.println("The checkbox is now checked.");
			}
		}else{
			if (!checkbox.isSelected()) {
				System.out.println("The checkbox is already unchecked.");
			} else {
				// Check the checkbox if it is not checked
				checkbox.click();
				System.out.println("The checkbox is now unchecked.");
			}
		}
	}

	public void clickContinue_FromAccountBilling(String checkoutUserType) {
		switch (checkoutUserType){
			case "registering":
				click_custom(DriverFactory.getInstance().getDriver().findElement(continue_button_registerAcc), "Continue button from registering user");
				break;
			case "guest":
				click_custom(DriverFactory.getInstance().getDriver().findElement(continue_button_guest), "Continue button from guest user");
				break;
			case "registered":
				click_custom(DriverFactory.getInstance().getDriver().findElement(continue_button_registerAcc), "Continue button from already registered user");
				break;
			default:
				System.out.println("Invalid CheckOutUserType! Expected: registering, guest, or registered.");
				break;
		}

	}

}


