package com.steps;


import org.junit.Assert;

import com.google.protobuf.TextFormat.ParseException;
import com.pages.DictionaryPage;
import com.pages.MyFreeDaysPage;
import com.pages.Newrequest_Page;
import com.pages.Vacation_days_left_page;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class Vacation_days_left_Steps extends ScenarioSteps {

	
	Vacation_days_left_page vacation_days_left_page;
	public Vacation_days_left_Steps vacation_days_left_steps;
	
	@Step
	public void enter_username(String username) {
		vacation_days_left_page.enter_username(username);
	}

	@Step
	public void enter_password(String password) {
		vacation_days_left_page.enter_password(password);
	}

	@Step
	public void sign_in() {
		vacation_days_left_page.press_sign_in();

	}

	@Step
	public void vacation_button_pressed() {
		vacation_days_left_page.vacation_press();
	}

	@Step
	public void login_click() {

		vacation_days_left_page.login_click();

	}
	@Step
	public void click_submit_button(){
		vacation_days_left_page.click_submit_button();
	}
	
	
	@Step
	public void click_Newrequest_button(){
		
		vacation_days_left_page.newrequest_press();
		
	}
	
	@Step
	public void new_req_button2(){
		vacation_days_left_page.new_req_press_again();
	}
	
	

	@Step
	public void is_the_home_page() {
		vacation_days_left_page.open();
	}
	
	/*@Step
	public void my_free_days_button_click(){
		vacation_days_left_page.click_my_free_days_button();
		
	}*/
	
	
	
	@Step
	 public void setStartDate(int month, int day, int year)
	   throws ParseException, java.text.ParseException {
		vacation_days_left_page.click_StartDate();
		vacation_days_left_page.settingDateByGivenParameter(month, day, year);
	 }

	 @Step
	 public void setEndDate(int month, int day, int year) throws ParseException, java.text.ParseException {
		 vacation_days_left_page.click_EndDate();
		 vacation_days_left_page.settingDateByGivenParameter(month, day, year);
	 }
	@Step
	public void get_difference(){
		vacation_days_left_page.difference();
		
	}
	@Step 
	public void get_vacacation_days_new(){
		vacation_days_left_page.Verify_DaysOfVacation_left();
		
	}

	
}
