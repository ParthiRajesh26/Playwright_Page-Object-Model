package playwrightFactory;

import com.microsoft.playwright.*;

public class Playwright_Factory {

	Playwright playwright;

	Browser browser;

	BrowserContext browserContext;

	Page page;

	public Page initBrowser(String browserName) {

		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {

		case "chrome":

			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

			break;

		case "firefox":

			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

			break;
		case "safari":

			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

			break;

		case "chromium":

			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			break;

		case "edge":

			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
			break;

		default:

			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		}

		browserContext = browser.newContext();

		page = browserContext.newPage();

		page.navigate("https://naveenautomationlabs.com/opencart/");

		return page;

	}

}
