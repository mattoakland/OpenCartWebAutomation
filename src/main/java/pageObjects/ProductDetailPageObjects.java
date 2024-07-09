package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.DriverFactory;
import testBase.TestBase;

import java.util.List;

public class ProductDetailPageObjects extends TestBase  {

	By addtoCart_btn = By.xpath("//button[@id='button-cart']");
	By review_tab = By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(), 'Reviews')]");
	By description_tab = By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(), 'Description')]");
	By name_txt_field=By.xpath("//input[@id='input-name']");
	By review_txt_field=By.xpath("//textarea[@id='input-review']");

	public void clickAddtoCart() {
		click_custom(DriverFactory.getInstance().getDriver().findElement(addtoCart_btn), "Add to Cart Button");
	}
	public void clickReviewTab() {
		click_custom(DriverFactory.getInstance().getDriver().findElement(review_tab), "Add to Cart Button");
	}
	public void clickDescriptionTab() {
		click_custom(DriverFactory.getInstance().getDriver().findElement(description_tab), "Add to Cart Button");
	}
	public void writeReview(String name,String review_txt,String rating) {
		//send name text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(name_txt_field), "LoginEmail TXT Field", name);
		//send review text
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(review_txt_field), "LoginEmail TXT Field", review_txt);

		//choose rating
		By rating_radio_btn=By.xpath("//input[@type='radio' and @name='rating' and @value='"+rating+"']");
		// Locate all radio buttons within the specific container
		WebElement radioButton = DriverFactory.getInstance().getDriver().findElement(rating_radio_btn);
		radioButton.click();
	}

}


