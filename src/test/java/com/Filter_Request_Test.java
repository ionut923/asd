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

	
	
String Vacation_Type, Days_Number, Vacation_Status ;
	
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
		endUser.enter_username("malu.ioan1");
		endUser.enter_password("evoportal");
		endUser.login_click();
		endUser.vacation_button_pressed();
		myRequest.myRequestPageClick();
		myRequest.checkboxFutureVacations();
		myRequest.selectFilterItem(Vacation_Type);
		myRequest.selectFilterItem(Days_Number);
		myRequest.selectFilterItem(Vacation_Status);
		/*myRequest.selectVacationTypeList(Vacation_Type);
		myRequest.selectVacationsDaysNumber(Days_Number);
		myRequest.selectVacationStatus(Vacation_Status);*/
		myRequest.applyButtonClick();

	}

}