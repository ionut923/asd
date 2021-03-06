package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.EndUserSteps;
import com.steps.MyFreeDaysSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class MyFreeDaysSearchTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public MyFreeDaysSteps endUser;

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
	public void myfreedayspage() {
		endUser.is_the_home_page();
		endUser.sign_in();
		endUser.enter_username("malu.ioan1");
		endUser.enter_password("evoportal");
		endUser.login_click();
		endUser.vacation_button_pressed();
		endUser.click_myfreedays();
		endUser.verify_free_days_number();
		
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