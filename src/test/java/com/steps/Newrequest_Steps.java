package com.steps;

import com.google.protobuf.TextFormat.ParseException;
import com.pages.DictionaryPage;
import com.pages.MyFreeDaysPage;
import com.pages.Newrequest_Page;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class Newrequest_Steps extends ScenarioSteps {

	//DictionaryPage myfreedayspage;
	Newrequest_Page newrequestpage;
	@Step
	public void enter_username(String username) {
		newrequestpage.enter_username(username);
	}

	@Step
	public void enter_password(String password) {
		newrequestpage.enter_password(password);
	}

	@Step
	public void sign_in() {
		newrequestpage.press_sign_in();

	}

	@Step
	public void vacation_button_pressed() {
		newrequestpage.vacation_press();
	}

	@Step
	public void login_click() {

		newrequestpage.login_click();

	}
	@Step
	public void click_submit_button(){
		newrequestpage.click_submit_button();
	}
	
	
	@Step
	public void click_Newrequest_button(){
		
		newrequestpage.newrequest_press();
//		xpath = "//td[text()='Free days given this year']/following-sibling::td"
	}
	
	/*@Step
	public void verify_free_days_number(){
		newrequestpage.verifyTheTotalnumberdays();
		
	}
	*/
	
	/*@Step
	public void getPageRibbon(String param){
		dictionaryPage.getPageRibbon(param);
	}*/

	/*
	 * @Step public void starts_search() { dictionaryPage.lookup_terms(); }
	 */
	/*
	 * @Step public void should_see_definition(String definition) {
	 * assertThat(dictionaryPage.getDefinitions(),
	 * hasItem(containsString(definition))); }
	 */

	@Step
	public void is_the_home_page() {
		newrequestpage.open();
	}
	
	
	
	@Step
	 public void setStartDate(int month, int day, int year)
	   throws ParseException, java.text.ParseException {
		newrequestpage.click_StartDate();
		newrequestpage.settingDateByGivenParameter(month, day, year);
	 }

	 @Step
	 public void setEndDate(int month, int day, int year) throws ParseException, java.text.ParseException {
		 newrequestpage.click_EndDate();
		 newrequestpage.settingDateByGivenParameter(month, day, year);
	 }
	
	

	/*
	 * @Step public void looks_for(String term) { enters(term); starts_search();
	 * }
	 */
}