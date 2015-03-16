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
import com.steps.MyRequestSteps;
import com.steps.Newrequest_Steps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
// @UseTestDataFrom("resources/dataTest.csv")
@UseTestDataFrom("Resources/FindMyRequest.csv")
public class VerifyTheExistenceOfMyReguestTest {

	// int startdate=Integer.
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	String start_month,start_day,start_year,end_month,end_day,end_year;

	@Steps
	public Newrequest_Steps endUser;
	
	@Steps
	public MyRequestSteps myRequest;

	
	
	
	
	
	@Test
	public void myfreedayspage() throws ParseException,	java.text.ParseException {
		
		
		//String verifyFirstDate, verifyEndDate;
		String startDate = start_day + "/" + start_month + "/" + start_year; 
		String endDate = end_day  + "/" + end_month + "/" + end_year; 
		
		endUser.is_the_home_page();
		endUser.sign_in();
		endUser.enter_username("maria.popescu");
		endUser.enter_password("mariapopescu");
		endUser.login_click();
		endUser.vacation_button_pressed();
		System.out.println(start_day);
//		endUser.click_Newrequest_button();
//		endUser.setStartDate(start_month, start_day, start_year);
//		endUser.setEndDate(end_month, start_day, end_year);
//		endUser.click_submit_button();
		
//mai trebuie modificat
		
		
		myRequest.myRequestPageClick();
		myRequest.checkboxFutureVacations();
		myRequest.findRequest(startDate);
		
		
		
		// endUser.click_myfreedays();
		// endUser.verify_free_days_number();
		// endUser.getPageRibbon("vacation");

	}
}
