package test_package;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import pageObjects.Homepage;
import playwrightFactory.Playwright_Factory;

public class Homepage_Test {

	Playwright_Factory factory;
	Page page;
	Homepage homepage;

	@BeforeTest
	public void setup() {

		factory = new Playwright_Factory();

		page = factory.initBrowser("edge");

		homepage = new Homepage(page);

	}

	@Test
	public void VerifyTitleTest() {

		String actualTitle = homepage.getHomepagetitle();

		Assert.assertEquals(actualTitle, "Your Store");

	}

	@Test
	public void VerifyUrlTest() {

		String actualUrl = homepage.getHomepageUrl();

		Assert.assertEquals(actualUrl, "https://naveenautomationlabs.com/opencart/");

	}

	@Test
	public void searchProduct() {

		String searchText = homepage.searchProduct("Macbook");

		Assert.assertEquals(searchText, "Search - Macbook");

	}

	@AfterTest
	public void Teardown() {

		page.context().browser().close();

	}

}
