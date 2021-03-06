package com.steps;

//package com.steps;

import com.google.protobuf.TextFormat.ParseException;
import com.pages.DictionaryPage;
import com.pages.MyFreeDaysPage;
import com.pages.Newrequest_Page;
import com.pages.Verify_text_from_comment_box_page;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class Verify_text_from_comment_box_Steps extends ScenarioSteps {

	//DictionaryPage myfreedayspage;
	Verify_text_from_comment_box_page verify_text_from_comment_box_page;
	@Step
	public void enter_username(String username) {
		verify_text_from_comment_box_page.enter_username(username);
	}

	@Step
	public void enter_password(String password) {
		verify_text_from_comment_box_page.enter_password(password);
	}

	@Step
	public void sign_in() {
		verify_text_from_comment_box_page.press_sign_in();

	}

	@Step
	public void vacation_button_pressed() {
		verify_text_from_comment_box_page.vacation_press();
	}

	@Step
	public void login_click() {

		verify_text_from_comment_box_page.login_click();

	}
	@Step
	public void click_submit_button(){
		verify_text_from_comment_box_page.click_submit_button();
	}
	
	
	@Step
	public void click_Newrequest_button(){
		
		verify_text_from_comment_box_page.newrequest_press();
//		xpath = "//td[text()='Free days given this year']/following-sibling::td"
	}
	@Step
	public void click_special_vacation_label(){
		verify_text_from_comment_box_page.click_special_vacation();
		
	}
	@Step
	public void click_on_other_option(){
		verify_text_from_comment_box_page.click_other_option();
		
	}
	@Step
	public void click_on_comment(){
		verify_text_from_comment_box_page.click_comment();
		
	}
	@Step
	public void click_on_text_zone(){
		verify_text_from_comment_box_page.click_text_zone();
		
	}
	@Step
	public void verify_text(){
		verify_text_from_comment_box_page.check_commented_text();
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
		verify_text_from_comment_box_page.open();
	}
	
	
	
	@Step
	 public void setStartDate(int month, int day, int year)
	   throws ParseException, java.text.ParseException {
		verify_text_from_comment_box_page.click_StartDate();
		verify_text_from_comment_box_page.settingDateByGivenParameter(month, day, year);
	 }

	 @Step
	 public void setEndDate(int month, int day, int year) throws ParseException, java.text.ParseException {
		 verify_text_from_comment_box_page.click_EndDate();
		 verify_text_from_comment_box_page.settingDateByGivenParameter(month, day, year);
	 }
	
	

	/*
	 * @Step public void looks_for(String term) { enters(term); starts_search();
	 * }
	 */
}