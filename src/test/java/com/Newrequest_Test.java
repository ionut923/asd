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

import com.google.protobuf.TextFormat.ParseException;
import com.requirements.Application;
import com.steps.Newrequest_Steps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom("resources/dataTest.csv")
@UseTestDataFrom("resources/Data_SetDate.csv")
public class Newrequest_Test {

	Integer start_month,end_day,start_year,end_month,end_dayx,end_year;
	//int startdate=Integer.
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public Newrequest_Steps endUser;


	
	@Test
	public void myfreedayspage() throws ParseException, java.text.ParseException {
		endUser.is_the_home_page();
		endUser.sign_in();
		endUser.enter_username("ionutciorba");
		endUser.enter_password("Solomon.923");
		endUser.login_click();
		endUser.vacation_button_pressed();
		endUser.click_Newrequest_button();
		endUser.setStartDate(start_month,end_day,start_year);
		endUser.setEndDate(end_month,end_day,end_year);
		endUser.click_submit_button();
		//endUser.click_myfreedays();
		//endUser.verify_free_days_number();
		
	//	endUser.getPageRibbon("vacation");

	}
}
