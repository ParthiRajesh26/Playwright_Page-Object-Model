package pageObjects;

import com.microsoft.playwright.Page;

public class Homepage {

	private Page page;

	public Homepage(Page page) {

		this.page = page;

	}

	private String search = "input[name='search']";

	private String button = ".btn.btn-default.btn-lg";

	private String searchText = "div[id='content']  h1";
	
	
	
	
	

	public String getHomepagetitle() {

		String title = page.title();

		System.out.println("Page title is: "+title);
		return title;

	}

	public String getHomepageUrl() {

		String url = page.url();
		System.out.println("Page Url is: "+url);
		return url;
		

	}

	public String searchProduct(String ProductName) {

		page.fill(search, ProductName);
		page.click(button);
		String searchActual = page.locator(searchText).textContent();
		System.out.println("Searchbox input is: "+searchActual);
		return searchActual;

	}

}
