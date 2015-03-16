package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.EndUserSteps;
import com.steps.MyRequestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/FiltersAndPages.csv")


public class CheckingFiltersChangingFiltersAndChangingPages {


String  filter,filterName,filterName1,filterName2,filterName3,filter2, filterNameII ;
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public MyRequestSteps myRequest;

	@Test
	public void requestsFilterTest() {
		endUser.is_the_home_page();
		endUser.sign_in();
		endUser.enter_username("maria.popescu");
		endUser.enter_password("mariapopescu");
		endUser.login_click();
		endUser.vacation_button_pressed();
		myRequest.myRequestPageClick();
		//myRequest.checkboxFutureVacations();
		myRequest.selectFilterItem(filterName);
		myRequest.selectFilterItem(filterName1);
		myRequest.selectFilterItem(filterName2);
		myRequest.selectFilterItem(filterName3);

		myRequest.applyButtonClick();
		myRequest.NextPageClick(filter, filterName);
		
		myRequest.selectFilterItem(filterNameII);
		myRequest.applyButtonClick();
		myRequest.NextPage(filter2, filterNameII);
		myRequest.selectFilterItem(filterName);
		myRequest.selectFilterItem(filterName1);
		myRequest.selectFilterItem(filterName2);
		myRequest.selectFilterItem(filterName3);

		myRequest.applyButtonClick();
		myRequest.NextPage(filter, filterName);
		
		myRequest.selectFilterItem(filterName);
		myRequest.selectFilterItem(filterNameII);
		myRequest.applyButtonClick();
		myRequest.NextPage(filter, filterName);
		

	}

}