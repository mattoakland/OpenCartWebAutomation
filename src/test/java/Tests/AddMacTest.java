package Tests;

import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ProductsPageObjects;
import pageObjects.ProductDetailPageObjects;
import testBase.TestBase;

/**
 * @author: Prakash Narkhede
 * @Youtube: https://www.youtube.com/automationtalks
 * @LinkedIn: https://www.linkedin.com/in/panarkhede89/
 */
@Test
public class AddMacTest extends TestBase{
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects();
	ProductsPageObjects productsPage = new ProductsPageObjects();
	ProductDetailPageObjects productDetailPage = new ProductDetailPageObjects();
	public void EnterProductPageTest() throws Throwable {
		//homePage.hoverOverMenu("Desktops");
		//Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel
		homePage.clickOnMenuItem("Desktops", "Mac");
		productsPage.clickOnProductName("iMac");
		Thread.sleep(2000);
		productDetailPage.clickReviewTab();
		productDetailPage.writeReview("Tally","Happy with the product!", "5");
		productDetailPage.clickAddtoCart();
		productDetailPage.clickDescriptionTab();
		Thread.sleep(2000);
	}
	public void addToCartTest() throws Throwable {
		//homePage.hoverOverMenu("Desktops");
		//Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel
		homePage.clickOnMenuItem("Desktops", "Mac");
		productsPage.clickAddtoWishList();
		productsPage.clickCompareProduct();
		productsPage.clickAddtoCart();
		Thread.sleep(2000);
	}

	public void enterSideMenuTest() throws Throwable {
		//homePage.hoverOverMenu("Desktops");
		//Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel
		homePage.clickOnMenuItem("Desktops", "Mac");
		productsPage.clickOnsideMenu_option("Phones");
		productsPage.setShowNumSetting("15");
		productsPage.setSortBySetting("Name (A - Z)");
		Thread.sleep(2000);
	}

/*		public void ClientLoginTest() throws Throwable {
		
		loginPage.login("client@localhost.com", "admin@123");
		Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel

	}
	public void DesignerLoginTest() throws Throwable {
		
		loginPage.login("designer@localhost.com", "admin@123");
		Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel
		assertEqualsString_custom("ExpectedTest", "ActualText", "LoginPageHomePage");

	}*/

}
