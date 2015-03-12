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
import com.steps.EndUserSteps;
import com.steps.MyFreeDaysSteps;
import com.steps.Newrequest_Steps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom("resources/dataTest.csv")
@UseTestDataFrom("resources/Data_startdate.csv")
public class Newrequest_Test {

	Integer start_month,end_day,start_year,end_month,end_dayx,end_year;
	//int startdate=Integer.
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public Newrequest_Steps endUser;

	/*
	 * @Test public void
	 * searching_by_keyword_apple_should_display_the_corresponding_article() {
	 * endUser.is_the_home_page(); endUser.looks_for("apple");
	 * endUser.should_see_definition(
	 * "A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates."
	 * );
	 * 
	 * }
	 */
	
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

	/*
	 * @Test public void
	 * searching_by_keyword_banana_should_display_the_corresponding_article() {
	 * endUser.is_the_home_page(); endUser.looks_for("pear");
	 * endUser.should_see_definition(
	 * "An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem."
	 * ); }
	 * 
	 * @Pending @Test public void
	 * searching_by_ambiguious_keyword_should_display_the_disambiguation_page()
	 * { }
	 */
}