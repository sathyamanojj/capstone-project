package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.keyword;

public class Search_Testclass4 extends BaseTest{



	
	keyword kw;

	@BeforeClass
	public void beforeClass() {
		kw = new keyword(driver);
	}

//	1. Use navigation, to search for mobile such as mi mobile
	@Test
	public void a_search_mimobile()
	{
		kw.Amazon_searchbox();
		
	}

//	2. Validate the results, for instance, 1-16 of 264 results for mi mobile
	@Test
	public void b_search_results()
	{
		kw.search_result();
	}
	
//3. Select Avg. Customer Review as 4 stars & up
	@Test
	public void c_customer_review()
	{
		kw.Average4starrating();
	}
	
//Select the first mobile, and in this case, Redmi Note 8 (Moonlight White, 6GB RAM, 128GB Storage)	
	@Test
	public void d_first_mobile()
	{
		kw.selectmobile();
		String title = kw.getCurrentPageTitle();
		Reporter.log(title);
		
	}
	
	
}
