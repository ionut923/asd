package com.steps;

import com.pages.DictionaryPage;
import com.pages.MyFreeDaysPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

	MyFreeDaysPage dictionaryPage;

	@Step
	public void enter_username(String username) {
		dictionaryPage.enter_username(username);
	}

	@Step
	public void enter_password(String password) {
		dictionaryPage.enter_password(password);
	}

	@Step
	public void sign_in() {
		dictionaryPage.press_sign_in();
	}
	
	@Step
	public void vacation_button_pressed() {
		dictionaryPage.vacation_press();
	}

	@Step
	public void login_click() {
		dictionaryPage.login_click();

	}
	
	@Step
	public void getPageRibbon(String param){
		dictionaryPage.getPageRibbon(param);
	}

	
//	@Step public void starts_search() { dictionaryPage.lookup_terms(); }
//	 
//	
//	@Step public void should_see_definition(String definition) {
//	assertThat(dictionaryPage.getDefinitions(),
//	hasItem(containsString(definition))); }
	 

	@Step
	public void is_the_home_page() {
		dictionaryPage.open();
		getDriver().manage().window().maximize();
	}

//    @Step
//    public void looks_for(String term) {
//        enters(term);
//        starts_search();
//    }
}
