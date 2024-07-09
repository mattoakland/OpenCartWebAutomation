package pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testBase.DriverFactory;
import testBase.TestBase;

public class ProductsPageObjects extends TestBase {
    By sort_by_dropdown = By.id("input-sort");
    By show_limit_dropdown = By.id("input-limit");

    public void clickOnsideMenu_option(String option) { //side menu bar has the options for choosing the product category.
        //String side_menu_bar = "product-category";
        String product_option_Xpath = "//aside[@id='column-left']//a[contains(text(),'"+option+"')]";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(product_option_Xpath)).click();
    }
    public void clickOnProductName(String product) {
        String product_name_clickable_Xpath = "//a[contains(text(),'"+product+"')]";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(product_name_clickable_Xpath)).click();
    }
    public void clickAddtoCart() {
        String addToCartXpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][1]//button[contains(@onclick, 'cart.add')]";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(addToCartXpath)).click();
    }
    public void clickAddtoWishList() {
        String addToWishListXpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][1]//button[contains(@onclick, 'wishlist.add')]";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(addToWishListXpath)).click();
    }
    public void clickCompareProduct() {
        String addToCompareXpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][1]//button[contains(@onclick, 'compare.add')]";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(addToCompareXpath)).click();
    }

    public void setSortBySetting(String sort_setting) {
        Select dropdown = new Select(DriverFactory.getInstance().getDriver().findElement(sort_by_dropdown));
        // Get the List of options in the dropdown
        List<WebElement> options = dropdown.getOptions();
        int numberOfOptions = options.size();
        System.out.println("Number of options in the dropdown: " + numberOfOptions);
        // Print the text of each option
        for (WebElement option : options) {
            System.out.println("Option text: " + option.getText());
        }

        dropdown.selectByVisibleText(sort_setting);
    }

    public void setShowNumSetting(String NumProducts) {
        Select dropdown = new Select(DriverFactory.getInstance().getDriver().findElement(show_limit_dropdown));
        // Get the List of options in the dropdown
        List<WebElement> options = dropdown.getOptions();
        int numberOfOptions = options.size();
        System.out.println("Number of options in the dropdown: " + numberOfOptions);
        // Print the text of each option
        for (WebElement option : options) {
            System.out.println("Option text: " + option.getText());
        }

        dropdown.selectByVisibleText(NumProducts);
    }
}
