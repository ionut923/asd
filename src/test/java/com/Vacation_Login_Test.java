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

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class Vacation_Login_Test {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	
	@Test
	public void gotovacationpage() {

		endUser.is_the_home_page();
		endUser.sign_in();
		endUser.enter_username("malu.ioan1");
		endUser.enter_password("evoportal");
		endUser.login_click();
		endUser.vacation_button_pressed();
	}
	
    @Test 
    public void login_action(){
    	
    	endUser.is_the_home_page();
    	endUser.sign_in();
    	endUser.enter_username("maria.popescu");
    	endUser.enter_password("mariapopescu");
    	endUser.login_click();
    	endUser.vacation_button_pressed();
    	
    	
    	
    }

}
