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

import com.google.protobuf.TextFormat.ParseException;
import com.requirements.Application;
//import com.steps.EndUserSteps;
import com.steps.MyFreeDaysSteps;
//import com.steps.Newrequest_Steps;
import com.steps.Vacation_days_left_Steps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)

@UseTestDataFrom("resources/Data_SetDate.csv")
public class Vacation_days_left_Test {

	public Integer start_month, end_day, start_year, end_month, end_dayx, end_year;
	//int startdate=Integer.
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public Vacation_days_left_Steps vacation_days_left_steps;

	
	
	@Test
	public void vacation_days_left_testing() throws ParseException, java.text.ParseException {
		vacation_days_left_steps.is_the_home_page();
		vacation_days_left_steps.sign_in();
		vacation_days_left_steps.enter_username("ionutciorba");
		vacation_days_left_steps.enter_password("Solomon.923");
		vacation_days_left_steps.login_click();
		vacation_days_left_steps.vacation_button_pressed();
		vacation_days_left_steps.click_Newrequest_button();
		vacation_days_left_steps.setStartDate(05, 18, 2015);
		vacation_days_left_steps.setEndDate(05, 19, 2015);
		vacation_days_left_steps.get_difference();
		vacation_days_left_steps.click_submit_button();
		vacation_days_left_steps.new_req_button2();
		vacation_days_left_steps.get_vacacation_days_new();
		//vacation_days_left_steps.my_free_days_button_click();
		

	}

	
}