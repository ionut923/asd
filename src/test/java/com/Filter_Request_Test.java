package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.EndUserSteps;
import com.steps.MyRequestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/filters.csv")
public class Filter_Request_Test {

	
	// filter: Vacation_Type, Days_Number, Vacation_Status
	// filterName: options
String /*Vacation_Type, Days_Number, Vacation_Status, */ filter,filterName,filterName1,filterName2,filterName3 ;
	
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
		myRequest.checkboxFutureVacations();
		myRequest.selectFilterItem(filterName);
		myRequest.selectFilterItem(filterName1);
		myRequest.selectFilterItem(filterName2);
		myRequest.selectFilterItem(filterName3);
		/*myRequest.checkFilters(filter, filterName);
		myRequest.checkFilters(filter, filterName1);
		myRequest.checkFilters(filter, filterName2);
		myRequest.checkFilters(filter, filterName3);*/
		myRequest.applyButtonClick();
		myRequest.NextPageClick(filter, filterName);
	

	}

}