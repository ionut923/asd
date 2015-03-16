package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.EndUserSteps;
import com.steps.FreeDaysCheckSteps;
import com.steps.MyRequestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class FreeDaysCheckTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public MyRequestSteps myRequest;
	
	@Steps
	public FreeDaysCheckSteps freeDaysCheckPage;

	@Test
	public void requestsFilterTest() {
		endUser.is_the_home_page();
		endUser.sign_in();
		endUser.enter_username("bojte.tamas");
		endUser.enter_password("shadowtomi");
		endUser.login_click();
		endUser.vacation_button_pressed();
		freeDaysCheckPage.myRequest_Button_click();
		freeDaysCheckPage.pending_button_checkbox_click();
		freeDaysCheckPage.myrequest_apply_button_click();
		freeDaysCheckPage.first_row_in_column1_click();
		freeDaysCheckPage.press_withdrawn_button();
	}
}