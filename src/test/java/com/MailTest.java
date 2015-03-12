package com;
import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.MailPage;
import com.SearchByKeywordStoryTest;
import com.steps.EndUserSteps;
import com.steps.Newrequest_Steps;
//import com.steps.NewVacationTestSteps;


@RunWith(ThucydidesRunner.class)






public class MailTest {

	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	@Steps 
	public Newrequest_Steps newVacationTestSteps;
	
	@Steps
	public EndUserSteps loginSteps;
	
	@Steps
	public SearchByKeywordStoryTest loginTest;
	
	@Steps
	public MailPage emailPageSteps;
	
	@Test
	public void checkingIfMailWasReceived() throws ParseException, MessagingException, IOException{
		//loginTest.login_action();
		newVacationTestSteps.is_the_home_page();
		 newVacationTestSteps.sign_in();
		  newVacationTestSteps.enter_username("maria.popescu");
		  newVacationTestSteps.enter_password("mariapopescu");
		  newVacationTestSteps.login_click();
		  newVacationTestSteps.vacation_button_pressed();
		  newVacationTestSteps.click_Newrequest_button();
		//newVacationTestSteps.new_vacation_open();
		newVacationTestSteps.setStartDate(2, 3, 2016);
		newVacationTestSteps.setEndDate(2, 4, 2016);
		newVacationTestSteps.click_submit_button();
		//newVacationTestSteps.createANewVacation();
		
		String startDate="03/02/2016";
		String endDate="04/02/2016";
		
		
		String body ="Your holiday interval is: <strong>" + startDate + " - " + endDate + "</strong>.";
	//	String body ="Please";
		
		
		emailPageSteps.checkLastEmailSubjectAndBody("You have submitted a new Vacation Request", body);
		
		
		
		}

	
	
	
}
