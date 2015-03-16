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
import com.steps.InboxSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class InboxTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public EndUserSteps endUser;
	
	@Steps
	public InboxSteps inSteps;

	

	@Test
	public void inbox_request_numbers() {
		endUser.is_the_home_page();
		endUser.sign_in();
		endUser.enter_username("bojte.tamas");
		endUser.enter_password("shadowtomi");
		endUser.login_click();
		endUser.vacation_button_pressed();
		inSteps.press_inbox_button();
		inSteps.select_the_value_from_inbox("b");
		
		
	}
	
	
}